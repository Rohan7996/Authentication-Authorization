package com.jwt.RegisterLogin.AuthenticationAuthorization.controllers;

import com.jwt.RegisterLogin.AuthenticationAuthorization.models.User;
import com.jwt.RegisterLogin.AuthenticationAuthorization.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public List<User> getUser(){
        System.out.println("getting user");
        return userService.getUsers();
    }
}
