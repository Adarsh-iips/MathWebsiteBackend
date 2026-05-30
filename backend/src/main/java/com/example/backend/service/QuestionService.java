package com.example.backend.service;

import com.example.backend.dto.QuestionDetailsResponse;
import com.example.backend.model.Question;
import com.example.backend.model.Solution;
import com.example.backend.repository.QuestionRepository;
import com.example.backend.repository.SolutionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    private final SolutionRepository solutionRepository;

    public QuestionService(
            QuestionRepository questionRepository,
            SolutionRepository solutionRepository
    ) {
        this.questionRepository = questionRepository;
        this.solutionRepository = solutionRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByChapter(
            String chapter
    ) {
        return questionRepository.findByChapter(
                chapter
        );
    }

    public List<Question> searchQuestions(
            String keyword
    ) {
        return questionRepository
                .findByQuestionTextContainingIgnoreCase(
                        keyword
                );
    }

    public List<Question> getByDifficulty(
            String difficulty
    ) {
        return questionRepository
                .findByDifficulty(
                        difficulty
                );
    }

    public List<Question> getByType(
            String type
    ) {
        return questionRepository
                .findByQuestionType(
                        type
                );
    }

    public Page<Question> getQuestionsPage(
            int page,
            int size
    ) {
        return questionRepository.findAll(
                PageRequest.of(page,size)
        );
    }

    public QuestionDetailsResponse getQuestionDetails(
            String questionId
    ) {

        Question question =
                questionRepository
                        .findByQuestionId(questionId)
                        .orElseThrow();

        Solution solution =
                solutionRepository
                        .findByQuestionId(questionId)
                        .orElse(null);

        return new QuestionDetailsResponse(
                question,
                solution
        );
    }

    public Question createQuestion(
            Question question
    ) {
        return questionRepository.save(
                question
        );
    }
}