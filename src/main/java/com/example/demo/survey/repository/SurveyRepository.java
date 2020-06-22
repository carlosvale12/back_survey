package com.example.demo.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Question;
import com.example.demo.entity.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long>{

	@Query(value = "SELECT Q FROM Question Q " +
			"INNER JOIN Survey S ON S.id = Q.survey.id " +
			"WHERE S.id = :id " )
	List<Question> findAllQuestion(@Param("id") Long id);

}
