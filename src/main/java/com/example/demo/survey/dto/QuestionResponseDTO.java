package com.example.demo.survey.dto;

import java.io.Serializable;

public class QuestionResponseDTO implements Serializable {

	private static final long serialVersionUID = -7225365735935564443L;
	
	private Long questionId;
	private String response;
	private Long idOption;

	public QuestionResponseDTO() {
	}

	public QuestionResponseDTO(Long questionId, String response, Long idOption) {
		super();
		this.questionId = questionId;
		this.response = response;
		this.idOption = idOption;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	public Long getIdOption() {
		return idOption;
	}
	public void setIdOption(Long idOption) {
		this.idOption = idOption;
	}

}
