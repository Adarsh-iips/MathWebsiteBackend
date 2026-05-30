package com.example.backend.controller;

import com.example.backend.dto.QuestionDetailsResponse;
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

    @GetMapping("/search")
    public List<Question> searchQuestions(
            @RequestParam String keyword
    ){
        return questionService
                .searchQuestions(keyword);
    }

    @GetMapping("/difficulty/{difficulty}")
    public List<Question> getByDifficulty(
            @PathVariable String difficulty
    ){
        return questionService
                .getByDifficulty(difficulty);
    }

    @GetMapping("/type/{type}")
    public List<Question> getByType(
            @PathVariable String type
    ){
        return questionService
                .getByType(type);
    }

    @GetMapping("/page")
    public org.springframework.data.domain.Page<Question>
    getQuestionsPage(

            @RequestParam(defaultValue = "0")
                    int page,

            @RequestParam(defaultValue = "10")
                    int size
    ){
        return questionService
                .getQuestionsPage(
                        page,
                        size
                );
    }

    @GetMapping("/{questionId}")
    public QuestionDetailsResponse getQuestionDetails(
            @PathVariable String questionId
    ){
        return questionService
                .getQuestionDetails(
                        questionId
                );
    }

    @PostMapping
    public Question createQuestion(
            @RequestBody Question question
    ) {
        return questionService.createQuestion(question);
    }
}
