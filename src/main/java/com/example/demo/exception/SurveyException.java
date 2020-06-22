package com.example.demo.exception;

public class SurveyException extends RuntimeException {

	private static final long serialVersionUID = -1234746913385032147L;
	
	private int errorCode;
	private String errorMessage;

	public SurveyException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
