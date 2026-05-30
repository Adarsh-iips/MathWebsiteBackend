package com.example.backend.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AdminOnlyFilter
        extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public AdminOnlyFilter(
            JwtUtil jwtUtil
    ) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(

            HttpServletRequest request,

            HttpServletResponse response,

            FilterChain filterChain

    ) throws ServletException, IOException {

        String requestURI =
                request.getRequestURI();

        if (!requestURI.startsWith(
                "/api/admin/upload"
        )) {

            filterChain.doFilter(
                    request,
                    response
            );

            return;
        }

        String authHeader =
                request.getHeader(
                        "Authorization"
                );

        if (authHeader == null ||
                !authHeader.startsWith(
                        "Bearer "
                )) {

            response.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    "Missing JWT Token"
            );

            return;
        }

        String token =
                authHeader.substring(7);

        String userType =
                jwtUtil.extractUserType(
                        token
                );

        if (!"ADMIN".equals(
                userType
        )) {

            response.sendError(
                    HttpServletResponse.SC_FORBIDDEN,
                    "Only admins can access this resource"
            );

            return;
        }

        filterChain.doFilter(
                request,
                response
        );
    }
}
