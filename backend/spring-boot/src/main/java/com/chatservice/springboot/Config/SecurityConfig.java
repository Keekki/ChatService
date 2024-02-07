package com.chatservice.springboot.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests( auth ->
                        auth
                                .requestMatchers("/admintool/**").authenticated() // Require authentication for /admintool (later more)
                                .anyRequest().permitAll() // Permit all other paths without authentication
                )
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling
                                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                )
                .oauth2Login(oauth2 -> oauth2
                                .loginPage("/login") // Specify the login page URL
                                .defaultSuccessUrl("/greet") // Specify the default success URL after login
                        // .userInfoEndpoint(userInfo -> userInfo.oidcUserService(this.oidcUserService())) // Optional: Configure OIDC user service
                );

        return http.build();
    }
}
