package com.devhub.backend.modules.auth.controller;

import com.devhub.backend.modules.auth.dto.LoginRequest;
import com.devhub.backend.modules.auth.dto.AuthResponse;
import com.devhub.backend.modules.auth.dto.RegisterRequest;
import com.devhub.backend.modules.auth.dto.RegisterResponse;
import com.devhub.backend.modules.auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest request){
        RegisterResponse response = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request){
        AuthResponse response = authService.login(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/test")
    public Authentication getCurrentUser(Authentication authentication) {
        return authentication;
    }
}
