package com.anhanguera.pw.resource.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.anhanguera.pw.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(System.currentTimeMillis(), status.value(),"Recurso não encontrado", e.getMessage());
		 return ResponseEntity.status(status).body(error);
	}
}
