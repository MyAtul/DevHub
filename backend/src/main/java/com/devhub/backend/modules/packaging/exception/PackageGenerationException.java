package com.devhub.backend.modules.packaging.exception;

public class PackageGenerationException extends RuntimeException{

    public PackageGenerationException(String message){
        super(message);
    }

    public PackageGenerationException(String message,Throwable cause){
        super(message, cause);
    }
}
