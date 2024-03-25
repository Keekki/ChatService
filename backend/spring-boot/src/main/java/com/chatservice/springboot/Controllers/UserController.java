package com.chatservice.springboot.Controllers;

import com.chatservice.springboot.Model.User;
import com.chatservice.springboot.Repository.UserRepository;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Collections;
import java.util.Map;
import java.util.Date;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/greet")
    public String greet(@AuthenticationPrincipal OAuth2User principal) {
        String username = principal != null ? principal.getAttribute("name") : "Guest";
        return "Hello, " + username + "!";
    }

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

    @PostMapping("/user/updateProfile")
    public ResponseEntity<?> updateProfile(@AuthenticationPrincipal OAuth2User principal,
                                           @RequestParam String bio,
                                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth,
                                           @RequestParam String location) {
        String email = principal.getAttribute("email");
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setBio(bio);
            user.setDateOfBirth(dateOfBirth);
            user.setLocation(location);
            userRepository.save(user);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
