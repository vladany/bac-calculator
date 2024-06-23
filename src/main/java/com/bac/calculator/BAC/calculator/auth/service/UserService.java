package com.bac.calculator.BAC.calculator.auth.service;

import com.bac.calculator.BAC.calculator.auth.repository.UserRepository;
import com.bac.calculator.BAC.calculator.auth.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public Optional<User> findByEmail(String username) {
        return userRepository.findByEmail(username);
    }
}
