package edu.spring.boot.api.users.controllers;

import edu.spring.boot.api.users.model.CreateUserRequest;
import edu.spring.boot.api.users.model.CreateUserResponse;
import edu.spring.boot.api.users.services.UserService;
import edu.spring.boot.api.users.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment env;

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    UserService userService;

    @GetMapping("/status")
    public String status() {
        return appName + ": " + env.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = modelMapper.map(createUserRequest, UserDto.class);

        userDto = userService.createUser(userDto);
        CreateUserResponse userResponse = modelMapper.map(userDto, CreateUserResponse.class);

        return new ResponseEntity(userResponse, HttpStatus.CREATED);
    }
}
