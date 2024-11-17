package com.example.howudoin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Disable CSRF for simplicity (not recommended for production)
                .authorizeHttpRequests()
                .anyRequest().permitAll() // Allow all requests without authentication
                .and()
                .headers().frameOptions().disable(); // Allow H2 console if needed

        return http.build();
    }
}
