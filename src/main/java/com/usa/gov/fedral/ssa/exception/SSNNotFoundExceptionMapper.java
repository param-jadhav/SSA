package com.usa.gov.fedral.ssa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class SSNNotFoundExceptionMapper extends ResponseEntityExceptionHandler {

	public SSNNotFoundExceptionMapper() {
		System.out.println("SSNNotFoundExceptionMapper.SSNNotFoundExceptionMapper()");
	}

	@ExceptionHandler(SSNNotfoundException.class)
	public ResponseEntity<InvalidSSN> exceptionHandler(SSNNotfoundException ex, WebRequest request) {
		//create InvalidSSN class object
		InvalidSSN exception = new InvalidSSN();
		exception.setStatusCode(400);
		exception.setErrorDesc("Invalid SSN");
		return new ResponseEntity<InvalidSSN>(exception,HttpStatus.BAD_REQUEST);
	}

}
