package com.example.generic_shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable()) // tắt csrf để test API
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll() // cho phép register/login
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}