package com.example.demo.common;

import java.io.Serializable;


public class BaseController implements Serializable{

	private static final long serialVersionUID = -3156869480617039654L;
	
	private ResponseServiceVo responseServiceVo;
	
	public BaseController() {
		responseServiceVo = new ResponseServiceVo();
	}
	public void resetResponse() {
		responseServiceVo = new ResponseServiceVo();
	}
	public ResponseServiceVo getResponseServiceVo() {
		return responseServiceVo;
	}
	public void setResponseServiceVo(ResponseServiceVo responseServiceVo) {
		this.responseServiceVo = responseServiceVo;
	}
	
}
