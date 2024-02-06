package com.chatservice.springboot.Controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PageController {

    @GetMapping("/")
    public String home() {
        return "Hello Home!";
    }

    @GetMapping("/greet")
    public String greet(@AuthenticationPrincipal OAuth2User principal) {
        String username = principal != null ? principal.getAttribute("name") : "Guest";
        return "Hello, " + username + "!";
    }
}
