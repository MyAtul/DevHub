package com.devhub.backend.modules.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequest {

    @NotBlank(message = "First name is required")
    @Size(max = 100)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 100)
    private String lastName;

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50)
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8,message = "Password must contain at least 8 characters")
    private String password;

    public RegisterRequest(){}

    public @NotBlank(message = "Last name is required") @Size(max = 100) String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "Last name is required") @Size(max = 100) String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank(message = "Username is required") @Size(min = 3, max = 50) String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Username is required") @Size(min = 3, max = 50) String username) {
        this.username = username;
    }

    public @NotBlank(message = "Email is required") @Email(message = "Invalid email") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required") @Email(message = "Invalid email") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Password is required") @Size(min = 8, message = "Password must contain at least 8 characters") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is required") @Size(min = 8, message = "Password must contain at least 8 characters") String password) {
        this.password = password;
    }

    public @NotBlank(message = "First name is required") @Size(max = 100) String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "First name is required") @Size(max = 100) String firstName) {
        this.firstName = firstName;
    }
}
