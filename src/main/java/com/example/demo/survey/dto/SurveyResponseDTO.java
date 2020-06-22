package com.example.demo.survey.dto;

import java.io.Serializable;
import java.util.List;

public class SurveyResponseDTO implements Serializable {

	private static final long serialVersionUID = 8201555576095871048L;

	private Long idSurvey;

	private List<QuestionResponseDTO> questionResponse;

	public SurveyResponseDTO() {

	}

	public SurveyResponseDTO(Long idSurvey, List<QuestionResponseDTO> questionResponse) {
		super();
		this.idSurvey = idSurvey;
		this.questionResponse = questionResponse;
	}

	public Long getIdSurvey() {
		return idSurvey;
	}

	public void setIdSurvey(Long idSurvey) {
		this.idSurvey = idSurvey;
	}

	public List<QuestionResponseDTO> getQuestionResponse() {
		return questionResponse;
	}

	public void setQuestionResponse(List<QuestionResponseDTO> questionResponse) {
		this.questionResponse = questionResponse;
	}

}
