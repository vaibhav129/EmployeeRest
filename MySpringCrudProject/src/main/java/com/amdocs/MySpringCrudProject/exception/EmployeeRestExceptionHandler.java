package com.amdocs.MySpringCrudProject.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException enfe) {
		EmployeeErrorResponse err = new EmployeeErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											enfe.getMessage(),
											System.currentTimeMillis());
		
		return new ResponseEntity(err,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(Exception ge) {
		EmployeeErrorResponse err = new EmployeeErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											ge.getMessage(),
											System.currentTimeMillis());
		
		return new ResponseEntity(err,HttpStatus.BAD_REQUEST);
	}

}
