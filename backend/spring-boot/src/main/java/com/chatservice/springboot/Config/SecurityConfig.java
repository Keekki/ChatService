package com.chatservice.springboot.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import com.chatservice.springboot.Service.CustomOAuth2UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests( auth ->
                        auth
                                // Add requestMatchers for posts, comments etc. if needed.
                                .requestMatchers("/admintool/**", "/users").hasRole("ADMIN") // Require admin rights for these paths
                                .anyRequest().permitAll() // Permit all other paths without authentication
                )
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling
                                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                )
                .oauth2Login(oauth2 -> oauth2
                                .loginPage("/login") // Specify the login page URL
                                .defaultSuccessUrl("/greet") // Specify the default success URL after login
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(customOAuth2UserService) // Using CustomOauth2UserService
                        )
                );

        return http.build();
    }
}
