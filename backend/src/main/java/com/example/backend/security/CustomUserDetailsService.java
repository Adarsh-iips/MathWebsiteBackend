package com.example.backend.security;

import com.example.backend.model.Admin;
import com.example.backend.model.Student;

import com.example.backend.repository.AdminRepository;
import com.example.backend.repository.StudentRepository;

import org.springframework.security.core.userdetails.*;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    private final AdminRepository adminRepository;

    private final StudentRepository studentRepository;

    public CustomUserDetailsService(
            AdminRepository adminRepository,
            StudentRepository studentRepository
    ) {
        this.adminRepository = adminRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(
            String username
    ) throws UsernameNotFoundException {

        Optional<Admin> adminOptional =
                adminRepository.findByUsername(
                        username
                );

        if (adminOptional.isPresent()) {

            Admin admin = adminOptional.get();

            return new User(
                    admin.getUsername(),
                    admin.getPassword(),
                    Collections.emptyList()
            );
        }

        Optional<Student> studentOptional =
                studentRepository.findByUsername(
                        username
                );

        if (studentOptional.isPresent()) {

            Student student = studentOptional.get();

            return new User(
                    student.getUsername(),
                    student.getPassword(),
                    Collections.emptyList()
            );
        }

        throw new UsernameNotFoundException(
                "User not found: " + username
        );
    }
}
