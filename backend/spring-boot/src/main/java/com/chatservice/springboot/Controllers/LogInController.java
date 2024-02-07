package com.chatservice.springboot.Controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LogInController {

    // OAuth2 login endpoint
    @GetMapping("/login")
    public String login() {
        return "redirect:/oauth2/authorization/google"; // Redirect to the OAuth2 login flow
    }

    // OAuth2 callback endpoint
    @GetMapping("/login/oauth2/callback")
    public String oauth2Callback(@AuthenticationPrincipal OAuth2User principal) {
        String username = principal.getAttribute("name");
        return "Login successful for user: " + username;
    }
}

