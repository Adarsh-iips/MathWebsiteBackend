package com.example.backend.repository;

import com.example.backend.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository
        extends MongoRepository<Question, String> {

    List<Question> findByChapter(String chapter);

    List<Question> findByDifficulty(String difficulty);

    List<Question> findByQuestionType(String questionType);

    List<Question> findByQuestionTextContainingIgnoreCase(
            String keyword
    );

    Optional<Question> findByQuestionId(
            String questionId
    );

    Page<Question> findAll(
            Pageable pageable
    );
}
