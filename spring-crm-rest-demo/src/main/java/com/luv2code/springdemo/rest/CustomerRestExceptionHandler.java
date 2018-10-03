package com.luv2code.springdemo.rest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	// add an exception handler for CustomerNotFoundException
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleExceptio(CustomerNotFoundException exc) {
		
		// create CustomerErrorResponse
		
		CustomerErrorResponse error = new CustomerErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()));
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	// Add another exception handler ... to catch any exception (catch all)
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc) {
		
		// create CustomerErrorResponse
		
		CustomerErrorResponse error = new CustomerErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()));
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
