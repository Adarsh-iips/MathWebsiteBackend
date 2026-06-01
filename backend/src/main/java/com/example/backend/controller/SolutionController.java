package com.example.backend.controller;

import com.example.backend.model.Solution;
import com.example.backend.service.SolutionService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/solutions")
@CrossOrigin("*")
public class SolutionController {

    private final SolutionService solutionService;

    public SolutionController(
            SolutionService solutionService
    ) {
        this.solutionService = solutionService;
    }

    @GetMapping("/question/{questionId}")
    public Solution getSolutionByQuestionId(
            @PathVariable String questionId
    ) {

        return solutionService.getByQuestionId(
                questionId
        );
    }
}
