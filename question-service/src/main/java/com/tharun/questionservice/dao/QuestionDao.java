package com.tharun.questionservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tharun.questionservice.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{ //class name which maps with the table and the primary key datatype

	List<Question> findByCategory(String category);
	
	@Query(value="SELECT q.id FROM question q Where q.category = :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
	List<Integer> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") int numQ);
}
