package com.xyztechch.quizapp.service;

import com.xyztechch.quizapp.dao.QuestionDao;
import com.xyztechch.quizapp.dao.QuizRepo;
import com.xyztechch.quizapp.dto.ResponseDto;
import com.xyztechch.quizapp.model.Question;
import com.xyztechch.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category,  int numQ, String title){
        List<Question> questionList = questionDao.findByRandomQuestionsByCategory(category,numQ);

            Quiz quiz = new Quiz();
                quiz.setTitle(title);
                quiz.setQuestions(questionList);
        quizRepo.save(quiz);
        return new ResponseEntity<>("\"Success\"", HttpStatus.OK);
    }

    public ResponseEntity<List<Question>> getQuizById(Long id) {

        Optional<Quiz> quiz = Optional.of(quizRepo.findById(id).orElseThrow());

        if(quiz.isPresent())
        {
            return new ResponseEntity<>(quiz.get().getQuestions(),HttpStatus.OK);
        }
         return null;

    }


    public ResponseEntity<Integer> calculateResult(Long id, List<ResponseDto> responses) {
        Quiz quiz = quizRepo.findById(id).orElseThrow();
        List<Question> questions = quiz.getQuestions();
        int result = 0;
        int i = 0;
       for (ResponseDto responseDto : responses) {
           if(responseDto.getAnswer().equals(questions.get(i).getRightAnswer())){
               result += 1;
           }
           i++;
       }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
