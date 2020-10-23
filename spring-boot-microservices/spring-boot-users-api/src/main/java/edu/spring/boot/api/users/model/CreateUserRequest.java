package edu.spring.boot.api.users.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateUserRequest {

    @NotNull(message = "First name cannot be null")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    private String lastName;

    @NotNull(message = "Password cannot be null")
    @Size(min = 2, max = 8, message = "Password must have between 2 and 8 characters")
    private String password;

    @NotNull(message = "Email name cannot be null")
    @Email
    private String email;
}
