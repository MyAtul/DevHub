package com.devhub.backend.modules.auth.service;

import com.devhub.backend.common.exception.EmailAlreadyExistsException;
import com.devhub.backend.common.exception.InvalidCredentialsException;
import com.devhub.backend.common.exception.UsernameAlreadyExistsException;
import com.devhub.backend.modules.auth.dto.*;
import com.devhub.backend.modules.auth.entity.User;
import com.devhub.backend.modules.auth.repository.UserRepository;
import com.devhub.backend.modules.auth.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, RefreshTokenService refreshTokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.refreshTokenService = refreshTokenService;
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {

        if(userRepository.existsByEmail(request.getEmail())){
            throw  new EmailAlreadyExistsException();
        }

        if(userRepository.existsByUsername(request.getUsername())){
            throw new UsernameAlreadyExistsException();
        }

        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User savedUser = userRepository.save(user);

        RegisterResponse response = new RegisterResponse();

        response.setId(savedUser.getId());
        response.setUsername(savedUser.getUsername());
        response.setEmail(savedUser.getEmail());
        response.setMessage("User Registered Successfully");

        return response;
    }

    @Override
    public AuthResponse login(LoginRequest request){

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(InvalidCredentialsException::new);

        if(!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        )){
            throw new InvalidCredentialsException();
        }

        String refreshToken = refreshTokenService.createRefreshToken(user);

        TokenPair tokenPair = jwtService.generateTokens(user,refreshToken);

        AuthResponse response = new AuthResponse();

        response.setAccessToken(tokenPair.getAccessToken());
        response.setRefreshToken(tokenPair.getRefreshToken());
        response.setTokenType("Bearer");
        response.setExpiresIn(tokenPair.getAccessTokenExpireIn());
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setMessage("Login Successful");

        return response;
    }
}
