package com.xyztechch.quizapp.service;

import com.xyztechch.quizapp.dao.QuizRepo;
import com.xyztechch.quizapp.dto.QuestionDto;
import com.xyztechch.quizapp.dto.ResponseDto;
import com.xyztechch.quizapp.feign.QuizzInterface;
import com.xyztechch.quizapp.model.Quiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private static final Logger log = LoggerFactory.getLogger(QuizService.class);
    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuizzInterface quizzInterface;

    public ResponseEntity<List<Integer>> createQuiz(String category,  int numQ, String title){

        List<Integer> questionsIds = quizzInterface.generateQuestionForQuiz(category,numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questionsIds);
        quizRepo.save(quiz);

        return new ResponseEntity<>(questionsIds, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionDto>> getQuizById(Long id) {

        Optional<Quiz> quiz = Optional.of(quizRepo.findById(id).orElseThrow());
        log.info("quizz {}", quiz.get().getQuestionsIds());

//        if(quiz.isPresent())
//        {
//            return new ResponseEntity<>(quiz.get().getQuestions(),HttpStatus.OK);
//        }
         return null;

    }


    public ResponseEntity<Integer> calculateResult(Long id, List<ResponseDto> responses) {
//        Quiz quiz = quizRepo.findById(id).orElseThrow();
//        List<Integer> questions = quiz.ge;
//        int result = 0;
//        int i = 0;
//       for (ResponseDto responseDto : responses) {
//           if(responseDto.getAnswer().equals(questions.get(i).getRightAnswer())){
//               result += 1;
//           }
//           i++;
//       }
//        return new ResponseEntity<>(result, HttpStatus.OK);
        return null;
    }
}
