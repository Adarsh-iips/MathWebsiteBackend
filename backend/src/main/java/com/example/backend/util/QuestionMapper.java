package com.example.backend.util;

import com.example.backend.dto.QuestionRequest;
import com.example.backend.dto.QuestionResponse;
import com.example.backend.model.Question;

public class QuestionMapper {

    public static Question toEntity(
            QuestionRequest dto
    ) {

        return Question.builder()
                .chapter(dto.getChapter())
                .topic(dto.getTopic())
                .difficulty(dto.getDifficulty())
                .questionType(dto.getQuestionType())
                .questionText(dto.getQuestionText())
                .marks(dto.getMarks())
                .estimatedTime(dto.getEstimatedTime())
                .tags(dto.getTags())
                .year(dto.getYear())
                .latexRequired(dto.getLatexRequired())
                .build();
    }

    public static QuestionResponse toDTO(
            Question question
    ) {

        return QuestionResponse.builder()
                .id(question.getId())
                .chapter(question.getChapter())
                .topic(question.getTopic())
                .difficulty(question.getDifficulty())
                .questionText(question.getQuestionText())
                .marks(question.getMarks())
                .tags(question.getTags())
                .build();
    }
}
