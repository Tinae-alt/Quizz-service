package com.xyztechch.quizapp.feign;

import com.xyztechch.quizapp.dto.QuestionDto;
import com.xyztechch.quizapp.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizzInterface {
    //generate
    @GetMapping("questions/generate")
    public ResponseEntity<List<Integer>> generateQuestionForQuiz(@RequestParam String category, @RequestParam int numQ);
    //getQuestions(quiz id)
    @PostMapping("questions/getQuestions")
    public ResponseEntity<List<QuestionDto>> getQuestiosFromId(@RequestBody List<Integer> ids);
    //getScore()
    @PostMapping("questions/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<ResponseDto> responses);
}
