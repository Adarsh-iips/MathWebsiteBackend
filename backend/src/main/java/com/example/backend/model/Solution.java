package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "solutions")
public class Solution {

    @Id
    private String id;

    private String questionId;

    private String solutionText;

    private String hint1;

    private String commonMistake;

    private String imageUrl;

    public Solution() {
    }

    public Solution(
            String id,
            String questionId,
            String solutionText,
            String hint1,
            String commonMistake,
            String imageUrl
    ) {
        this.id = id;
        this.questionId = questionId;
        this.solutionText = solutionText;
        this.hint1 = hint1;
        this.commonMistake = commonMistake;
        this.imageUrl = imageUrl;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String id;
        private String questionId;
        private String solutionText;
        private String hint1;
        private String commonMistake;
        private String imageUrl;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder questionId(String questionId) {
            this.questionId = questionId;
            return this;
        }

        public Builder solutionText(String solutionText) {
            this.solutionText = solutionText;
            return this;
        }

        public Builder hint1(String hint1) {
            this.hint1 = hint1;
            return this;
        }

        public Builder commonMistake(String commonMistake) {
            this.commonMistake = commonMistake;
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Solution build() {
            return new Solution(
                    id,
                    questionId,
                    solutionText,
                    hint1,
                    commonMistake,
                    imageUrl
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

    public String getSolutionText() {
        return solutionText;
    }

    public void setSolutionText(String solutionText) {
        this.solutionText = solutionText;
    }

    public String getHint1() {
        return hint1;
    }

    public void setHint1(String hint1) {
        this.hint1 = hint1;
    }

    public String getCommonMistake() {
        return commonMistake;
    }

    public void setCommonMistake(String commonMistake) {
        this.commonMistake = commonMistake;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
