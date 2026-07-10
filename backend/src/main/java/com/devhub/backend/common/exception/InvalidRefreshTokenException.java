package com.devhub.backend.common.exception;

import org.springframework.http.HttpStatus;

public class InvalidRefreshTokenException extends BusinessException{

    public InvalidRefreshTokenException() {
        super("Invalid or expire refresh token", HttpStatus.UNAUTHORIZED);
    }
}
