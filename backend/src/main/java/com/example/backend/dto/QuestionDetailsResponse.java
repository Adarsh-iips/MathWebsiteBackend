package com.example.backend.dto;

import com.example.backend.model.Question;
import com.example.backend.model.Solution;

public class QuestionDetailsResponse {

    private Question question;

    private Solution solution;

    public QuestionDetailsResponse() {
    }

    public QuestionDetailsResponse(
            Question question,
            Solution solution
    ) {
        this.question = question;
        this.solution = solution;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }
}
