package com.example.howudoin.repositories;

import com.example.howudoin.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email); // Find user by email
}
