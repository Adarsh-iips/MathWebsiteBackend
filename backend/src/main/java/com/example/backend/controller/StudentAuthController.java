package com.example.backend.controller;

import com.example.backend.dto.AdminLoginRequest;
import com.example.backend.dto.AuthResponse;
import com.example.backend.dto.StudentSignUpRequest;

import com.example.backend.service.StudentAuthService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@CrossOrigin("*")
public class StudentAuthController {

    private final StudentAuthService studentAuthService;

    public StudentAuthController(
            StudentAuthService studentAuthService
    ) {
        this.studentAuthService = studentAuthService;
    }

    @PostMapping("/register")
    public String register(

            @RequestBody
                    StudentSignUpRequest request
    ) {

        return studentAuthService
                .register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(

            @RequestBody
                    AdminLoginRequest request
    ) {

        return studentAuthService
                .login(request);
    }
}
