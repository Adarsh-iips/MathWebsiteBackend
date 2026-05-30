package com.example.backend.service;

import com.example.backend.dto.AuthResponse;
import com.example.backend.dto.AdminLoginRequest;
import com.example.backend.security.JwtUtil;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.stereotype.Service;

@Service
public class AdminAuthService {

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    public AdminAuthService(
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse login(
            AdminLoginRequest request
    ) {

        authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        String token =
                jwtUtil.generateToken(
                        request.getUsername(),
                        "ADMIN"
                );

        return new AuthResponse(token);
    }
}
