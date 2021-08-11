package com.springsrescuemisson.kenneltracker.exception;

public class ValidationException extends Exception{

	private static final long serialVersionUID = 772846981647080981L;

	public ValidationException() {
		super();
	}
	
	public ValidationException(String message) {
		super(message);
	}
}
