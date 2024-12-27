package com.example.howudoin.controllers;

import com.example.howudoin.models.User;
import com.example.howudoin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        System.out.println("Request received: " + user); // Debugging log

        try {
            // Check if the user already exists
            if (userService.getUserByEmail(user.getEmail()).isPresent()) {
                System.out.println("Email already in use: " + user.getEmail());
                return ResponseEntity.badRequest().body("Email already in use.");
            }

            userService.addUser(user); // Save the user to MongoDB
            System.out.println("User registered: " + user); // Debugging log
            return ResponseEntity.ok("User registered successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }


    // Login a user
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User loginRequest) {
        Optional<User> optionalUser = userService.getUserByEmail(loginRequest.getEmail());

        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(401).body("User not found.");
        }

        User user = optionalUser.get();
        if (user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password.");
        }
    }
}