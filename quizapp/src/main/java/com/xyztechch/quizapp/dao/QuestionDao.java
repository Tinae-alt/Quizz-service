package com.xyztechch.quizapp.dao;

import com.xyztechch.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Long> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<Question> findByRandomQuestionsByCategory(String category, int numQ);
}
