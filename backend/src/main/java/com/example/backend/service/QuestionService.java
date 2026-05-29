package com.example.backend.service;

import com.example.backend.model.Question;
import com.example.backend.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByChapter(String chapter) {
        return questionRepository.findByChapter(chapter);
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }
}
