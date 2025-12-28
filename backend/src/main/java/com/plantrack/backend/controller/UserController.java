package com.plantrack.backend.controller; // Make sure this matches your folder structure

import com.plantrack.backend.model.User;
import com.plantrack.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // <--- 1. CRITICAL: Tells Spring this class handles web requests
@RequestMapping("/users") // <--- 2. CRITICAL: Sets the base URL to localhost:8080/users
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // This handles the POST request you are trying to send
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // This handles the GET request to see all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}