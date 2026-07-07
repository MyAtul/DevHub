package com.devhub.backend.modules.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequest {

    @NotBlank(message = "Email is Required")
    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Password is needed")
    @Size(min = 8,message = "Password must contain at least 8 characters")
    private String password;

    public @NotBlank(message = "Message is Required") @Email(message = "Invalid email") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Message is Required") @Email(message = "Invalid email") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Password is needed") @Size(min = 8, message = "Password must contain at least 8 characters") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is needed") @Size(min = 8, message = "Password must contain at least 8 characters") String password) {
        this.password = password;
    }
}
