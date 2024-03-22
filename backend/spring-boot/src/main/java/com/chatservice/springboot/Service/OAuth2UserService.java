package com.chatservice.springboot.Service;

import com.chatservice.springboot.Model.User;
import com.chatservice.springboot.Repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OAuth2UserService extends DefaultOAuth2UserService {

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
        }
        userEntity.setUserName(name);
        userRepository.save(userEntity);
        return user;
    }
}
