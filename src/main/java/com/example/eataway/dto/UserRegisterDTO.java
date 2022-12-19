package com.example.eataway.dto;

import com.example.eataway.dto.validation.FieldMatch;
import com.example.eataway.dto.validation.UniqueEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords do not match."
)
public class UserRegisterDTO {
    @Size(min = 3, max = 25, message = "Username should be between 3 and 25 symbols.")
    @NotBlank
    @UniqueEmail(message = "Username already taken.")
    private String username;

    @Email
    private String email;

    @Size(min = 2, max = 20)
    @NotBlank
    private String firstName;

    private String lastName;

    @Size(min = 5, max = 30)
    @NotBlank
    private String password;

    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
