package com.grocery.management.service;

import com.grocery.management.domain.User;
import com.grocery.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by arshi on 5/15/2020.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User loadUserByUsername(String username) {
        return userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User: " + username + " not found"));
    }
}


