package com.xyztechch.quizapp.service;

import com.xyztechch.quizapp.dao.QuestionDao;
import com.xyztechch.quizapp.dto.QuestionDto;
import com.xyztechch.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;
   public List<Question> getAllQuestions(){
       List<Question> questions = questionDao.findAll();
       return questions;
    }

    public ResponseEntity<List<Question>> getAllQuestionsByCategory(String category) {
        List<Question> questionsByCategory = questionDao.findByCategory(category);
        return new ResponseEntity<> (questionsByCategory, HttpStatus.OK);
    }

    public ResponseEntity<String> addQuestion(QuestionDto questionDto) {
                Question question = Question.builder()
                        .category(questionDto.getCategory())
                        .questionTitle(questionDto.getQuestionTitle())
                        .option1(questionDto.getOption1())
                        .option2(questionDto.getOption2())
                        .option3(questionDto.getOption3())
                        .option4(questionDto.getOption4())
                        .rightAnswer(questionDto.getRightAnswer())
                        .difficultyLevel(questionDto.getDifficultyLevel())
                        .build();
                questionDao.save(question);
                String response = "success";
                return ResponseEntity.ok(response);

    }
}
