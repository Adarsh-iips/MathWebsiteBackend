package com.example.backend.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class QuestionRequest {

    @NotBlank
    private String chapter;

    @NotBlank
    private String topic;

    @NotBlank
    private String questionId;

    @NotBlank
    private String difficulty;

    private String questionType;

    @NotBlank
    private String questionText;

    private Integer marks;

    private Integer estimatedTime;

    private List<String> tags;

    private Integer year;

    private Boolean latexRequired;

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public Integer getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Integer estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getLatexRequired() {
        return latexRequired;
    }

    public void setLatexRequired(Boolean latexRequired) {
        this.latexRequired = latexRequired;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
}
