package com.devhub.backend.modules.auth.security;

import com.devhub.backend.modules.auth.dto.TokenPair;
import com.devhub.backend.modules.auth.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    TokenPair generateTokens(User user,String refreshToken);

    String extractUsername(String token);

    boolean isTokenValid(String token, UserDetails userDetails);

    boolean isTokenExpired(String token);

}
