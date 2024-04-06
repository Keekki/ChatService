package com.chatservice.springboot.Service;

import com.chatservice.springboot.Model.User;
import com.chatservice.springboot.Repository.UserRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(userRequest);
        // Extract user details from OAuth2User
        String email = user.getAttribute("email");
        String name = user.getAttribute("name");
        // Save or update the user in your database
        User userEntity = userRepository.findByEmail(email);
        if (userEntity == null) {
            userEntity = new User();
            userEntity.setEmail(email);
            userEntity.setUserName(name);
            // Set default role or other properties as needed
        } else {
            // Update existing user details if necessary
            userEntity.setUserName(name);
        }
        userRepository.save(userEntity);

        // Assign roles based on the admin flag
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        if (userEntity.isAdmin()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        // Return a new OAuth2User object with the assigned authorities
        return new DefaultOAuth2User(authorities, user.getAttributes(), "email");
    }
}

