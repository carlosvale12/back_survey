package com.example.demo.survey.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Option;
import com.example.demo.entity.Question;
import com.example.demo.entity.QuestionResponse;
import com.example.demo.entity.SurveyResponse;
import com.example.demo.exception.SurveyException;
import com.example.demo.survey.dto.OptionDTO;
import com.example.demo.survey.dto.QuestionDTO;
import com.example.demo.survey.dto.QuestionResponseDTO;
import com.example.demo.survey.dto.SurveyResponseDTO;
import com.example.demo.survey.repository.OptionRepository;
import com.example.demo.survey.repository.QuestionRepository;
import com.example.demo.survey.repository.QuestionResponseRepository;
import com.example.demo.survey.repository.SurveyRepository;
import com.example.demo.survey.repository.SurveyResponseRepository;
import com.example.demo.survey.service.SurveyService;

@Service("surveyService")
public class SurveyServiceImpl implements SurveyService {

	@Autowired private SurveyRepository repository;
	@Autowired private SurveyResponseRepository surveyResponseRepository;
	@Autowired private QuestionRepository questionRepository;
	@Autowired private QuestionResponseRepository qresponseRepository;
	@Autowired private OptionRepository optionRepository;
	
	@Override
	public List<QuestionDTO> getByID(Long id) throws SurveyException {
		List<Question> entities = repository.findAllQuestion(id);
		return entities.stream().map(data -> newSurveyDTO(data))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public SurveyResponseDTO saveSurveyResponse(@Valid SurveyResponseDTO surveyDTO) throws SurveyException {
		SurveyResponse response = new SurveyResponse();
		surveyResponseRepository.saveAndFlush(response);
		
		for (QuestionResponseDTO dto : surveyDTO.getQuestionResponse()) {
			Question question = questionRepository.findById(dto.getQuestionId()).orElse(null);
			if(null != question) {
				Option option = null;
				QuestionResponse questionResponse = new QuestionResponse();
				questionResponse.setQuestion(question);
				questionResponse.setSurveyResponse(response);
				if(dto.getIdOption()>0) {
					option = optionRepository.findById(dto.getIdOption()).orElse(null);
					questionResponse.setResponse(option.getDescription());
				} else {
					questionResponse.setResponse(dto.getResponse());
				}
				qresponseRepository.save(questionResponse);
			}
		}
		
		return surveyDTO;
	}
	
	private QuestionDTO newSurveyDTO(Question entity) {
		return new QuestionDTO(entity.getSurvey().getId(), entity.getId(), entity.getDescription(),
				entity.getNullText(), entity.getType(), getOptions(entity.getOptions()));
	}
	
	private List<OptionDTO> getOptions(List<Option> entities){
		return entities.stream().map(data -> new OptionDTO(data.getId(), data.getDescription()))
				.collect(Collectors.toList());
	}

}
