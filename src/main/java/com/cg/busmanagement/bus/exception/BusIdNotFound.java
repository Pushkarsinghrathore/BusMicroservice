	/****************************************************************************************************************************
	 - File Name        : Bus Service Exception
	 - Author           : Pushkar Singh Rathore
	 - Creation Date    : 13-06-2020
	 - Description      : This is a exception class to throw the exception when bus ID not found.
	  ****************************************************************************************************************************/ 
	package com.cg.busmanagement.bus.exception;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class BusIdNotFound extends Exception {
	
		
		
		
	
		public BusIdNotFound(String string) {
		// TODO Auto-generated constructor stub
	}


		/****************************************************************************************************************************
		 - Method Name      : BusIdNotFound
		 - Author           : Pushkar Singh Rathore
		 - Creation Date    : 13-06-2020
		 - Description      : For passing the exception
		  ****************************************************************************************************************************/ 
		
		
			
			@ExceptionHandler(BusIdNotFound.class)
			public String handleException(BusIdNotFound e) {
				
				return e.getMessage();
			}
			

			@ExceptionHandler(BusIdNotFound.class)
			public Map<String, String> handleConstraintViolation(ConstraintViolationException ex) {
			    Map<String, String> errors = new HashMap<>();
			     
			    ex.getConstraintViolations().forEach(cv -> {
			        errors.put("message", cv.getMessage());
			        errors.put("path", (cv.getPropertyPath()).toString());
			    }); 
			    return errors;
			}
			

			
		
		
	
	}