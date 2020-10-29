package edu.spring.boot.api.users.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateUserResponse {

    private String firstName;
    private String lastName;
    private String email;
    private String userId;
}
