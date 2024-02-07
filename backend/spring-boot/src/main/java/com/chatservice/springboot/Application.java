package com.chatservice.springboot;

import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class}) // Remove the exclude when adding a database
   @RestController
   public class Application {

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

       public static void main(String[] args) {
           SpringApplication.run(Application.class, args);
       }
   }