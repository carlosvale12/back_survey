package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String description;

	@Column(name="null_text")
	private Boolean nullText;

	private Integer type;

	//bi-directional many-to-one association to Option
	@OneToMany(mappedBy="question")
	private List<Option> options;

	//bi-directional many-to-one association to Survey
	@ManyToOne
	private Survey survey;

	//bi-directional many-to-one association to QuestionResponse
	@OneToMany(mappedBy="question")
	private List<QuestionResponse> questionResponses;

	public Question() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getNullText() {
		return this.nullText;
	}

	public void setNullText(Boolean nullText) {
		this.nullText = nullText;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<Option> getOptions() {
		return this.options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Option addOption(Option option) {
		getOptions().add(option);
		option.setQuestion(this);

		return option;
	}

	public Option removeOption(Option option) {
		getOptions().remove(option);
		option.setQuestion(null);

		return option;
	}

	public Survey getSurvey() {
		return this.survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public List<QuestionResponse> getQuestionResponses() {
		return this.questionResponses;
	}

	public void setQuestionResponses(List<QuestionResponse> questionResponses) {
		this.questionResponses = questionResponses;
	}

	public QuestionResponse addQuestionRespons(QuestionResponse questionRespons) {
		getQuestionResponses().add(questionRespons);
		questionRespons.setQuestion(this);

		return questionRespons;
	}

	public QuestionResponse removeQuestionRespons(QuestionResponse questionRespons) {
		getQuestionResponses().remove(questionRespons);
		questionRespons.setQuestion(null);

		return questionRespons;
	}
	
}
