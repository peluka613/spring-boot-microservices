package edu.spring.boot.api.account.manager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private Environment env;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/status")
    public String status() {
        return appName + ": " + env.getProperty("local.server.port");
    }
}
