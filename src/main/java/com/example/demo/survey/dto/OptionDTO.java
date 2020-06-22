package com.example.demo.survey.dto;

import java.io.Serializable;

public class OptionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6745281969993456813L;
	private Long id; 
	private String description;
	
	public OptionDTO() {
		
	}
	
	public OptionDTO(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
