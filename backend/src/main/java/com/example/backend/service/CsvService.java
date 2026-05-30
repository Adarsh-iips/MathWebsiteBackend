package com.example.backend.service;

import com.example.backend.model.Question;
import com.example.backend.model.Solution;
import com.example.backend.repository.QuestionRepository;

import com.example.backend.repository.SolutionRepository;
import com.opencsv.CSVReader;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvService {

    private final QuestionRepository questionRepository;
    private final SolutionRepository solutionRepository;

    public CsvService(
            QuestionRepository questionRepository,
            SolutionRepository solutionRepository
    ) {
        this.questionRepository = questionRepository;
        this.solutionRepository = solutionRepository;
    }

    public String uploadQuestionsCsv(
            MultipartFile file
    ) {

        try {

            CSVReader reader =
                    new CSVReader(
                            new InputStreamReader(
                                    file.getInputStream()
                            )
                    );

            List<String[]> rows = reader.readAll();

            List<Question> questions =
                    new ArrayList<>();

            for (int i = 1; i < rows.size(); i++) {

                String[] row = rows.get(i);

                Question question =
                        Question.builder()

                                .questionId(row[0])

                                .chapter(row[1])

                                .topic(row[2])

                                .difficulty(row[3])

                                .questionType(row[4])

                                .questionText(row[5])

                                .marks(
                                        Integer.parseInt(row[6])
                                )

                                .estimatedTime(
                                        Integer.parseInt(row[7])
                                )

                                .year(
                                        Integer.parseInt(row[8])
                                )

                                .latexRequired(
                                        Boolean.parseBoolean(row[9])
                                )

                                .build();

                questions.add(question);
            }

            questionRepository.saveAll(
                    questions
            );

            return "CSV Uploaded Successfully";

        } catch (Exception e) {

            e.printStackTrace();

            return "CSV Upload Failed";
        }
    }

    public String uploadSolutionsCsv(
            MultipartFile file
    ) {

        try {

            CSVReader reader =
                    new CSVReader(
                            new InputStreamReader(
                                    file.getInputStream()
                            )
                    );

            List<String[]> rows =
                    reader.readAll();

            List<Solution> solutions =
                    new ArrayList<>();

            for(int i=1;i<rows.size();i++) {

                String[] row = rows.get(i);

                Solution solution =
                        Solution.builder()
                                .questionId(row[0])
                                .solutionText(row[1])
                                .hint1(row[2])
                                .commonMistake(row[3])
                                .imageUrl(row[4])
                                .build();

                solutions.add(solution);
            }

            solutionRepository.saveAll(
                    solutions
            );

            return "Solutions Uploaded Successfully";

        }

        catch (Exception e){

            e.printStackTrace();

            return "Solutions Upload Failed";
        }
    }
}
