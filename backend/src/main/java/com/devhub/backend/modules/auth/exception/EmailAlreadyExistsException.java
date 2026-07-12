package com.devhub.backend.modules.auth.exception;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExistsException extends BusinessException{

    public EmailAlreadyExistsException(){
       super("Email Already Exists",HttpStatus.CONFLICT);
    }
}
