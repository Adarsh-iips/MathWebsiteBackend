package com.example.backend.controller;

import com.example.backend.model.Question;
import com.example.backend.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin("*")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/chapter/{chapter}")
    public List<Question> getQuestionsByChapter(
            @PathVariable String chapter
    ) {
        return questionService.getQuestionsByChapter(chapter);
    }

    @PostMapping
    public Question createQuestion(
            @RequestBody Question question
    ) {
        return questionService.createQuestion(question);
    }
}
