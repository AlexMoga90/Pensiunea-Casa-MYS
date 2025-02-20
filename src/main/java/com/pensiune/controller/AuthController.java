package com.pensiune.controller;

import com.pensiune.model.User;
import com.pensiune.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pensiune.service.AuthService;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String username,
                                           @RequestParam String password) {
        userService.registerUser(username, password, "USER");
        return ResponseEntity.ok("User registered successfully!");
    }
}


