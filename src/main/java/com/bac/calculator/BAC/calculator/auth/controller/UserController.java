package com.bac.calculator.BAC.calculator.auth.controller;

import com.bac.calculator.BAC.calculator.auth.service.AuthenticationService;
import com.bac.calculator.BAC.calculator.auth.service.CustomUserDetailsService;
import com.bac.calculator.BAC.calculator.auth.service.UserService;
import com.bac.calculator.BAC.calculator.auth.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.registerNewUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest) {

        String token = userService.loginUser(loginRequest);
         return ResponseEntity.ok(token);
    }
}
