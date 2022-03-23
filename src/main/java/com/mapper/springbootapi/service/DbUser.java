package com.mapper.springbootapi.service;

import com.mapper.springbootapi.domain.User;
import com.mapper.springbootapi.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbUser {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
    }
}
