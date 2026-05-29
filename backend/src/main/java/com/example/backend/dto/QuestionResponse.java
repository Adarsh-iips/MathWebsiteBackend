package com.example.backend.dto;

import java.util.List;

public class QuestionResponse {

    private String id;

    private String chapter;

    private String topic;

    private String difficulty;

    private String questionText;

    private Integer marks;

    private List<String> tags;

    public QuestionResponse() {
    }

    public QuestionResponse(
            String id,
            String chapter,
            String topic,
            String difficulty,
            String questionText,
            Integer marks,
            List<String> tags
    ) {
        this.id = id;
        this.chapter = chapter;
        this.topic = topic;
        this.difficulty = difficulty;
        this.questionText = questionText;
        this.marks = marks;
        this.tags = tags;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String id;
        private String chapter;
        private String topic;
        private String difficulty;
        private String questionText;
        private Integer marks;
        private List<String> tags;

        public Builder id(String id) {
            this.id = id;
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

        public Builder questionText(String questionText) {
            this.questionText = questionText;
            return this;
        }

        public Builder marks(Integer marks) {
            this.marks = marks;
            return this;
        }

        public Builder tags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public QuestionResponse build() {
            return new QuestionResponse(
                    id,
                    chapter,
                    topic,
                    difficulty,
                    questionText,
                    marks,
                    tags
            );
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
