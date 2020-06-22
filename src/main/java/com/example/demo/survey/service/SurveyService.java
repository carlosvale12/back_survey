package com.example.demo.survey.service;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.exception.SurveyException;
import com.example.demo.survey.dto.QuestionDTO;
import com.example.demo.survey.dto.SurveyResponseDTO;

public interface SurveyService {
	List<QuestionDTO> getByID(Long id) throws SurveyException;
	SurveyResponseDTO saveSurveyResponse(@Valid SurveyResponseDTO surveyDTO)throws SurveyException;
}
