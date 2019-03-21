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
	public ResponseEntity<SSNNotfoundException> exceptionHandler(SSNNotfoundException ex, WebRequest request) {
		return new ResponseEntity<SSNNotfoundException>(HttpStatus.BAD_REQUEST);
	}

}
