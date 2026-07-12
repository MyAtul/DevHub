package com.devhub.backend.modules.auth.exception;

import com.devhub.backend.modules.auth.response.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {

   @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiErrorResponse> handleBusinessException(
            BusinessException ex,
            HttpServletRequest request
    ){
        ApiErrorResponse response = new ApiErrorResponse();

        response.setTimestamp(java.time.LocalDateTime.now());

        HttpStatus status = ex.getStatus();
        response.setStatus(status.value());
        response.setError(status.getReasonPhrase());

        response.setMessage(ex.getMessage());
        response.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(response);
    }
}
