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

}
