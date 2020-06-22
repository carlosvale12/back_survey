package com.example.demo.survey.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.common.BaseController;
import com.example.demo.common.ResponseServiceVo;
import com.example.demo.exception.SurveyException;
import com.example.demo.survey.dto.SurveyResponseDTO;
import com.example.demo.survey.service.SurveyService;

@RestController
@RequestMapping("/survey")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class SurveyController extends BaseController {

	private static final long serialVersionUID = 5176512722089845090L;
	
	@Autowired SurveyService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseServiceVo> getByID(@PathVariable Long id) throws SurveyException {
		getResponseServiceVo().setData(service.getByID(id));
		return new ResponseEntity<ResponseServiceVo>(getResponseServiceVo(), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ResponseServiceVo> saveSurveyResponse(@Valid @RequestBody(required = true) SurveyResponseDTO surveyDTO)
			throws SurveyException {
		getResponseServiceVo().setData(service.saveSurveyResponse(surveyDTO));
		return new ResponseEntity<ResponseServiceVo>(getResponseServiceVo(), HttpStatus.OK);
	}
	

}
