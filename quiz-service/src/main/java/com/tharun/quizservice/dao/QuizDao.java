package com.tharun.quizservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tharun.quizservice.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
