package com.xyztechch.quizapp.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class QuizzDto {
    String category;
    int numQuestions;
    String title;
}
