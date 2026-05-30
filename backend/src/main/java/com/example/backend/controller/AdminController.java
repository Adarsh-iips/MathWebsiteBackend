package com.example.backend.controller;

import com.example.backend.dto.AdminLoginRequest;
import com.example.backend.dto.AuthResponse;
import com.example.backend.service.AdminAuthService;
import com.example.backend.service.CsvService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    private final CsvService csvService;
    private final AdminAuthService adminAuthService;
    public AdminController(
            CsvService csvService,
            AdminAuthService adminAuthService
    ) {
        this.csvService = csvService;
        this.adminAuthService = adminAuthService;
    }

    @PostMapping("/upload/questions")
    public String uploadQuestionsCsv(
            @RequestParam("file")
                    MultipartFile file
    ) {

        return csvService.uploadQuestionsCsv(
                file
        );
    }

    @PostMapping("/upload/solutions")
    public String uploadSolutionsCsv(
            @RequestParam("file")
                    MultipartFile file
    ){

        return csvService.uploadSolutionsCsv(
                file
        );
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody AdminLoginRequest request
    ) {

        return adminAuthService.login(
                request
        );
    }
}
