package com.example.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

	@ExceptionHandler(SurveyException.class)
	public ResponseEntity<ErrorResponse> exceptionToDoHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setStatusResponse(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessageResponse(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> exceptionValidationHandler(Exception ex) {
		MethodArgumentNotValidException notValidException = (MethodArgumentNotValidException) ex;
		ErrorResponse error = new ErrorResponse();
		error.setStatusResponse(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessageResponse(notValidException.getBindingResult().getAllErrors().get(0).getDefaultMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		LOGGER.error("Exception: ", ex);
		ErrorResponse error = new ErrorResponse();
		error.setStatusResponse(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessageResponse("El servidor no pudo comprender la solicitud debido a una sintaxis mal formada.");
		error.setServerError(ex.getStackTrace().toString());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> exceptionHandlerRuntime(Exception exceptionRuntime) {
		LOGGER.error("ExceptionRuntime: ", exceptionRuntime);
		RuntimeException runtimeException = (RuntimeException) exceptionRuntime;
		ErrorResponse error = new ErrorResponse();
		error.setMessageResponse("Ocurrio un error en el servidor.");
		error.setStatusResponse(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setServerError(runtimeException.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
