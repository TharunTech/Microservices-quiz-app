package com.tharun.quizservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tharun.quizservice.dao.QuizDao;
import com.tharun.quizservice.feign.QuizInterface;
import com.tharun.quizservice.model.QuestionWrapper;
import com.tharun.quizservice.model.Quiz;
import com.tharun.quizservice.model.Response;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;

	@Autowired
	QuizInterface quizInterface;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

		// call the generate url - RestTemplate http://localhost:8080/question/generate
		List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();

		Quiz quiz = new Quiz();

		quiz.setTitle(title);
		quiz.setQuestionsIds(questions);

		quizDao.save(quiz);

		return new ResponseEntity<>("successfully created a quiz ", HttpStatus.CREATED);

	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

		Quiz quiz = quizDao.findById(id).get();

		List<Integer> questionIds = quiz.getQuestionsIds();
		ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);

		return questions;
	}

	public ResponseEntity<String> calculateResult(Integer id, List<Response> responses) {

		ResponseEntity<String> score = quizInterface.getScore(responses);

		return score;

	}

}
