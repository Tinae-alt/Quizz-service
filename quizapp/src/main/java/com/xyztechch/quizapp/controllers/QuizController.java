package com.xyztechch.quizapp.controllers;


import com.xyztechch.quizapp.dto.ResponseDto;
import com.xyztechch.quizapp.model.Question;
import com.xyztechch.quizapp.service.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
@Slf4j
public class QuizController {
   private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<List<Question>> getQuizById(@PathVariable("id") Long id){
        log.info("===Category==={}",id);
        return quizService.getQuizById(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> getQuizById(@PathVariable("id") Long id ,@RequestBody List<ResponseDto> responses){
        log.info("===Category==={}",id);
        return quizService.calculateResult(id,responses);
    }
}
