package spring.boot.microservices.usersapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment env;

    @GetMapping
    public String getUsers(){
        return "Users controller: " + env.getProperty("local.server.port");
    }
}
