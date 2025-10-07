package com.mkj.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppCommonExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ExceptionResponse> 
			sendingResponseToInvalidDocuments(InvalidDocumentidException exp)
	{
		
		/*
		 *  create response
		 * 
		 * */
		System.out.println("inside exception handler");
		ExceptionResponse resp = new ExceptionResponse();
		resp.setErrorMsg(exp.toString());
		resp.setIssueSrc("ABC Test");
		resp.setNow(LocalDateTime.now());
		
		
		
		return new ResponseEntity<ExceptionResponse>(resp,HttpStatusCode.valueOf(500));
	}
	
	
	
	
}//end class
