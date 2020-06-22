package com.example.demo.common;

import java.io.Serializable;

public class ResponseServiceVo implements Serializable{

	private static final long serialVersionUID = -2267031731949273489L;
	private String messageResponse;
	private int statusResponse;
	private Object data;
	
	public ResponseServiceVo() {
		this.messageResponse = "OK";
		this.statusResponse = 200;
	}
	
	public ResponseServiceVo(String messageResponse, int statusResponse) {
		this.messageResponse = messageResponse;
		this.statusResponse = statusResponse;
	}

	public String getMessageResponse() {
		return messageResponse;
	}

	public void setMessageResponse(String messageResponse) {
		this.messageResponse = messageResponse;
	}

	public int getStatusResponse() {
		return statusResponse;
	}

	public void setStatusResponse(int statusResponse) {
		this.statusResponse = statusResponse;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
