package com.example.howudoin.controllers;

import com.example.howudoin.models.User;
import com.example.howudoin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // Tüm kullanıcıları getir
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Yeni kullanıcı ekle
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // E-posta ile kullanıcı bul
    @GetMapping("/users/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı!"));
    }
}
