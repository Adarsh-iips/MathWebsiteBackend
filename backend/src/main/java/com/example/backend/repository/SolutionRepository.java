package com.example.backend.repository;

import com.example.backend.model.Solution;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SolutionRepository extends MongoRepository<Solution, String> {

    Optional<Solution> findByQuestionId(String questionId);
}
