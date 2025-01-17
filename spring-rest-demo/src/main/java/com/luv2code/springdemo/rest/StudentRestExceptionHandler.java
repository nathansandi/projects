package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	//add exception handling code here

	//Add an exception handler user 
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
		//create a StudenterrorResponse
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		
		
		return  new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
		
	}
	
	//add another exception handler ,,, to catch any excop
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		//create a StudenterrorResponse
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		
		
		return  new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
		
		
	}
	
}
