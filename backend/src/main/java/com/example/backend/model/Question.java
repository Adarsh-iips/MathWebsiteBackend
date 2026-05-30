package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "questions")
public class Question {

    @Id
    private String id;
    private String questionId;
    private String chapter;
    private String topic;
    private String difficulty;
    private String questionType;

    private String questionText;

    private Integer marks;
    private Integer estimatedTime;

    private List<String> tags;

    private Integer year;

    private Boolean latexRequired;

    public Question() {
    }

    public Question(
            String id,
            String questionId,
            String chapter,
            String topic,
            String difficulty,
            String questionType,
            String questionText,
            Integer marks,
            Integer estimatedTime,
            List<String> tags,
            Integer year,
            Boolean latexRequired
    ) {
        this.id = id;
        this.questionId=questionId;
        this.chapter = chapter;
        this.topic = topic;
        this.difficulty = difficulty;
        this.questionType = questionType;
        this.questionText = questionText;
        this.marks = marks;
        this.estimatedTime = estimatedTime;
        this.tags = tags;
        this.year = year;
        this.latexRequired = latexRequired;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String id;
        private String questionId;
        private String chapter;
        private String topic;
        private String difficulty;
        private String questionType;
        private String questionText;
        private Integer marks;
        private Integer estimatedTime;
        private List<String> tags;
        private Integer year;
        private Boolean latexRequired;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder questionId(String questionId) {
            this.questionId = questionId;
            return this;
        }

        public Builder chapter(String chapter) {
            this.chapter = chapter;
            return this;
        }

        public Builder topic(String topic) {
            this.topic = topic;
            return this;
        }

        public Builder difficulty(String difficulty) {
            this.difficulty = difficulty;
            return this;
        }

        public Builder questionType(String questionType) {
            this.questionType = questionType;
            return this;
        }

        public Builder questionText(String questionText) {
            this.questionText = questionText;
            return this;
        }

        public Builder marks(Integer marks) {
            this.marks = marks;
            return this;
        }

        public Builder estimatedTime(Integer estimatedTime) {
            this.estimatedTime = estimatedTime;
            return this;
        }

        public Builder tags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public Builder year(Integer year) {
            this.year = year;
            return this;
        }

        public Builder latexRequired(Boolean latexRequired) {
            this.latexRequired = latexRequired;
            return this;
        }

        public Question build() {
            return new Question(
                    id,
                    questionId,
                    chapter,
                    topic,
                    difficulty,
                    questionType,
                    questionText,
                    marks,
                    estimatedTime,
                    tags,
                    year,
                    latexRequired
            );
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

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
}