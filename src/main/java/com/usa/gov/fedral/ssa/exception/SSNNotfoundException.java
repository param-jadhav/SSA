package com.usa.gov.fedral.ssa.exception;

public class SSNNotfoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SSNNotfoundException() {
		System.out.println("SSNNotfoundException.SSNNotfoundException()");
	}

	public SSNNotfoundException(String message) {
		super(message);
	}
}
