package com.javier.user.service;

/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javier.user.model.entity.UserEntity;
import com.javier.user.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String saveUser(UserEntity userEntity) {
    	userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        repository.save(userEntity);
        return "user added to the system";
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }


}*/