package com.xyztechch.quizapp.controllers;


import com.xyztechch.quizapp.dto.QuestionDto;
import com.xyztechch.quizapp.model.Question;
import com.xyztechch.quizapp.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("questions")
public class QuestionController {
  private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("allQuestions")
    public List<Question> getQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{cat}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable("cat") String category){
        log.info("===Category==={}",category);
        return questionService.getAllQuestionsByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionDto questionDto){
        log.info("===Question to add==={}",questionDto);
        return questionService.addQuestion(questionDto);
    }

}
