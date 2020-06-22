package com.example.demo.survey.dto;

import java.io.Serializable;
import java.util.List;

public class QuestionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6408472228653885855L;
	private Long idSurvey;
	private Long question_id;
	private String descriptionQuestion;
	private Boolean null_text;
	private int type;
	List<OptionDTO> options;
	
	public QuestionDTO() {}
	
	public QuestionDTO(Long idSurvey, Long question_id, String descriptionQuestion, Boolean null_text, int type,
			List<OptionDTO> options) {
		super();
		this.idSurvey = idSurvey;
		this.question_id = question_id;
		this.descriptionQuestion = descriptionQuestion;
		this.null_text = null_text;
		this.type = type;
		this.options = options;
	}

	public Long getIdSurvey() {
		return idSurvey;
	}

	public void setIdSurvey(Long idSurvey) {
		this.idSurvey = idSurvey;
	}

	public Long getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
	}

	public String getDescriptionQuestion() {
		return descriptionQuestion;
	}

	public void setDescriptionQuestion(String descriptionQuestion) {
		this.descriptionQuestion = descriptionQuestion;
	}

	public Boolean getNull_text() {
		return null_text;
	}

	public void setNull_text(Boolean null_text) {
		this.null_text = null_text;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<OptionDTO> getOptions() {
		return options;
	}

	public void setOptions(List<OptionDTO> options) {
		this.options = options;
	}
	
	
}
