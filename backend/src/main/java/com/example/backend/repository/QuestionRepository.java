package com.example.backend.repository;

import com.example.backend.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepository extends MongoRepository<Question, String> {

    List<Question> findByChapter(String chapter);

    List<Question> findByDifficulty(String difficulty);
}
