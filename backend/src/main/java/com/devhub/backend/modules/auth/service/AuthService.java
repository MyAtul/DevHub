package com.devhub.backend.modules.auth.service;

import com.devhub.backend.modules.auth.dto.RegisterRequest;
import com.devhub.backend.modules.auth.dto.RegisterResponse;

public interface AuthService {

    RegisterResponse register(RegisterRequest request);
}
