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
import org.springframework.web.bind.annotation.PathVariable;



import java.util.Collections;
import java.util.Map;
import java.util.Date;
import java.util.List;
import java.util.HashMap;




@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/greet")
    public String greet(@AuthenticationPrincipal OAuth2User principal) {
        String username = principal != null ? principal.getAttribute("name") : "Guest";
        return "Hello, " + username + "!";
    }

    // Returns the current logged in users data
    @GetMapping("/user")
    public ResponseEntity<?> user(@AuthenticationPrincipal OAuth2User principal) {
        String email = principal.getAttribute("email");
        User user = userRepository.findByEmail(email);
        if (user != null) {
            Map<String, Object> userData = new HashMap<>();
            userData.put("ID: ", user.getIdUser());
            userData.put("Name: ", user.getUserName());
            userData.put("Email: ", user.getEmail());
            // Exclude the admin field
            userData.put("Bio: ", user.getBio());
            userData.put("Birthdate: ", user.getDateOfBirth());
            userData.put("Location: ", user.getLocation());
            return ResponseEntity.ok(userData);
        }
        return ResponseEntity.notFound().build();
    }

    // Returns a specific users data
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(value = "id") Long idUser) {
        User user = userRepository.findById(idUser)
                .orElse(null); // or .orElseThrow() to throw an exception if user not found

        if (user != null) {
            Map<String, Object> userData = new HashMap<>();
            userData.put("ID: ", user.getIdUser());
            userData.put("Name: ", user.getUserName());
            userData.put("Email: ", user.getEmail());
            // Exclude the admin field
            userData.put("Bio: ", user.getBio());
            userData.put("Birthdate: ", user.getDateOfBirth());
            userData.put("Location: ", user.getLocation());
            return ResponseEntity.ok(userData);
        }
        return ResponseEntity.notFound().build();
    }


    // Endpoint that returns all the users in the database
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
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
