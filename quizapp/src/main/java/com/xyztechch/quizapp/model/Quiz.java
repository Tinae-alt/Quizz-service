package com.xyztechch.quizapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bouncycastle.util.Integers;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
     @ElementCollection
    private List<Integer> questionsIds;
}
