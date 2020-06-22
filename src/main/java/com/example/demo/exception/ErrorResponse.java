package com.example.demo.exception;

import java.io.Serializable;

public class ErrorResponse implements Serializable {
	
	private static final long serialVersionUID = 7807355392754201551L;
	
	private int statusResponse;
	private String messageResponse;
	private String serverError;
	
	public int getStatusResponse() {
		return statusResponse;
	}
	public void setStatusResponse(int statusResponse) {
		this.statusResponse = statusResponse;
	}
	public String getMessageResponse() {
		return messageResponse;
	}
	public void setMessageResponse(String messageResponse) {
		this.messageResponse = messageResponse;
	}
	public String getServerError() {
		return serverError;
	}
	public void setServerError(String serverError) {
		this.serverError = serverError;
	}
}
