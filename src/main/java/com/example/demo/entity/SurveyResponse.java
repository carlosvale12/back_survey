package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "survey_response")
public class SurveyResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// bi-directional many-to-one association to QuestionResponse
	@OneToMany(mappedBy = "surveyResponse")
	private List<QuestionResponse> questionResponses;

	public SurveyResponse() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<QuestionResponse> getQuestionResponses() {
		return this.questionResponses;
	}

	public void setQuestionResponses(List<QuestionResponse> questionResponses) {
		this.questionResponses = questionResponses;
	}

	public QuestionResponse addQuestionRespons(QuestionResponse questionRespons) {
		getQuestionResponses().add(questionRespons);
		questionRespons.setSurveyResponse(this);

		return questionRespons;
	}

	public QuestionResponse removeQuestionRespons(QuestionResponse questionRespons) {
		getQuestionResponses().remove(questionRespons);
		questionRespons.setSurveyResponse(null);

		return questionRespons;
	}

}
