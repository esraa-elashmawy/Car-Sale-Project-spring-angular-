package com.luv2code.springboot.carsale.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CarRestExceptionHandler {
	
	// add an exception handler 
	@ExceptionHandler
	public ResponseEntity<CarErrorResponse> handleException(CarNotFoundException exec){
		//create a studentErrorResponse
		CarErrorResponse error = new CarErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exec.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return  new ResponseEntity<>(error,HttpStatus.NOT_FOUND) ;
		
	}
	
	
	// add an exception handler ... to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<CarErrorResponse> handleException(Exception exec){
		//create a studentErrorResponse
		CarErrorResponse error = new CarErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exec.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return  new ResponseEntity<>(error,HttpStatus.BAD_REQUEST) ;
		
	}


}
