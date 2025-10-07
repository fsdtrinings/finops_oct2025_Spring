package com.mkj.app.exception;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
		resp.setIssueSrc(exp.getStackTrace()[0].getMethodName()+"");
		resp.setNow(LocalDateTime.now());
		
		
		
		return new ResponseEntity<ExceptionResponse>(resp,HttpStatusCode.valueOf(500));
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {

        // Collect all validation field errors
        Map<String, String> fieldErrors = new HashMap<>();
        
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            fieldErrors.put(error.getField(), error.getDefaultMessage());
        }

        ExceptionResponse resp = new ExceptionResponse();
        resp.setErrorMsg("Validation Failed");
        resp.setIssueSrc(ex.getStackTrace()[0].getMethodName()+"");
        resp.setNow(LocalDateTime.now());
        resp.setErrorFieldInfo(fieldErrors); // put the field error map of our response map

        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }
}//end class
