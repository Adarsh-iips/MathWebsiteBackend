package com.example.backend.service;

import com.example.backend.dto.AuthResponse;
import com.example.backend.dto.AdminLoginRequest;
import com.example.backend.dto.StudentSignUpRequest;

import com.example.backend.model.Student;
import com.example.backend.repository.StudentRepository;
import com.example.backend.security.JwtUtil;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentAuthService {

    private final StudentRepository studentRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    public StudentAuthService(
            StudentRepository studentRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil
    ) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public String register(
            StudentSignUpRequest request
    ) {

        Student student =
                new Student();

        student.setUsername(
                request.getUsername()
        );

        student.setEmail(
                request.getEmail()
        );

        student.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );

        studentRepository.save(
                student
        );

        return "Student Registered Successfully";
    }

    public AuthResponse login(
            AdminLoginRequest request
    ) {

        Student student =
                studentRepository
                        .findByUsername(
                                request.getUsername()
                        )
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Student not found"
                                )
                        );

        if (!passwordEncoder.matches(
                request.getPassword(),
                student.getPassword()
        )) {

            throw new RuntimeException(
                    "Invalid Credentials"
            );
        }

        String token =
                jwtUtil.generateToken(
                        student.getUsername(),
                        "STUDENT"
                );

        return new AuthResponse(
                token
        );
    }
}
