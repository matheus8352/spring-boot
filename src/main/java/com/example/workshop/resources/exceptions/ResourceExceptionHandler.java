package com.example.workshop.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.workshop.services.exceptions.DatabaseException;
import com.example.workshop.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException resourceException, HttpServletRequest httpServletRequest) {
		String errorName = "Resource not found";
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), errorName, resourceException.getMessage(), httpServletRequest.getRequestURI());
		return ResponseEntity.status(httpStatus).body(standardError);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> dataBaseError(DatabaseException dataBaseExecption, HttpServletRequest httpServletRequest) {
		String errorName = "Database Error";
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), errorName, dataBaseExecption.getMessage(), httpServletRequest.getRequestURI());
		return ResponseEntity.status(httpStatus).body(standardError);
	}
}
