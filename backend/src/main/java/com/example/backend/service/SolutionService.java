package com.example.backend.service;

import com.example.backend.model.Solution;
import com.example.backend.repository.SolutionRepository;

import org.springframework.stereotype.Service;

@Service
public class SolutionService {

    private final SolutionRepository solutionRepository;

    public SolutionService(
            SolutionRepository solutionRepository
    ) {
        this.solutionRepository = solutionRepository;
    }

    public Solution getByQuestionId(
            String questionId
    ) {

        return solutionRepository
                .findByQuestionId(
                        questionId
                )
                .orElseThrow(
                        () -> new RuntimeException(
                                "Solution not found"
                        )
                );
    }
}
