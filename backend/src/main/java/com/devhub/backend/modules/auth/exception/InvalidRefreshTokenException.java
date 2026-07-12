package com.devhub.backend.modules.auth.exception;

import org.springframework.http.HttpStatus;

public class InvalidRefreshTokenException extends BusinessException{

    public InvalidRefreshTokenException() {
        super("Invalid or expire refresh token", HttpStatus.UNAUTHORIZED);
    }
}
