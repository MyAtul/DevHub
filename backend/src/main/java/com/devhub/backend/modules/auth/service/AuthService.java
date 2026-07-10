package com.devhub.backend.modules.auth.service;

import com.devhub.backend.modules.auth.dto.*;

public interface AuthService {

    RegisterResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

    AuthResponse refreshToken(RefreshTokenRequest request);
}
