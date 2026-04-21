package com.example.generic_shop.service.Impl;


import com.example.generic_shop.dto.LoginRequest;
import com.example.generic_shop.entity.User;
import com.example.generic_shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ResponseEntity<?> register(User user){
        if (userRepository.findByEmail(user.getEmail()).isPresent()){
            return ResponseEntity.status(400).body("Email already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return ResponseEntity.status(201).body("User registered successfully");

    }

    public ResponseEntity<?> login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail()).orElse(null);

        if (user == null){
            return ResponseEntity.status(404).body("User not found");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            return ResponseEntity.status(401).body("Invalid password");
        }

        return ResponseEntity.ok(user);

    }

}
