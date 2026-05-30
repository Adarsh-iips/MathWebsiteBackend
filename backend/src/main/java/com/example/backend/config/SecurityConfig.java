package com.example.backend.config;

import com.example.backend.security.AdminOnlyFilter;
import com.example.backend.security.JWTAuthenticationFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JWTAuthenticationFilter jwtFilter;

    private final AdminOnlyFilter adminOnlyFilter;

    public SecurityConfig(
            JWTAuthenticationFilter jwtFilter,
            AdminOnlyFilter adminOnlyFilter
    ) {

        this.jwtFilter = jwtFilter;
        this.adminOnlyFilter = adminOnlyFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config
    ) throws Exception {

        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {

        http

                .csrf(csrf -> csrf.disable())

                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(
                                "/api/admin/login",
                                "/api/student/login",
                                "/api/student/register"
                        ).permitAll()

                        .requestMatchers(
                                "/api/questions/**"
                        ).permitAll()

                        .requestMatchers(
                                "/api/admin/upload/**"
                        ).authenticated()

                        .anyRequest()
                        .authenticated()
                )

                .addFilterBefore(
                        jwtFilter,
                        UsernamePasswordAuthenticationFilter.class
                )

                .addFilterAfter(
                        adminOnlyFilter,
                        JWTAuthenticationFilter.class
                );

        return http.build();
    }
}
