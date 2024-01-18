package com.chatservice.springboot.Chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    // This is a simple placeholder for the greet functionality
    // In a real-world scenario, you would have user authentication and data management
    @GetMapping("/greet")
    public String greet(@RequestParam(value = "name", defaultValue = "Guest") String name) {
        return "Hello, " + name + "!";
    }

    // Uncomment and implement the following when adding login and user data management
    /*
    @PostMapping("/login")
    public String login(@RequestBody UserLoginDto userLoginDto) {
        // Logic to authenticate user and create user session
        return "Login successful for user: " + userLoginDto.getUsername();
    }
    */
}
