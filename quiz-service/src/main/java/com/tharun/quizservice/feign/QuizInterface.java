package com.tharun.quizservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.tharun.quizservice.model.QuestionWrapper;
import com.tharun.quizservice.model.Response;





@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
	
	//generate questions - ids of the questions are sent as response
	@GetMapping("question/generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestions);
	
	//getQuestions(questionid)//getting as per the ids of the questions in List format
	@PostMapping("question/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);
	
	//getScore
	@PostMapping("question/getScore")
	public ResponseEntity<String> getScore(@RequestBody List<Response> responses);
}
