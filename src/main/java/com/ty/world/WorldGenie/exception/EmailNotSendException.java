package com.ty.world.WorldGenie.exception;

public class EmailNotSendException extends RuntimeException {

	String message="Error in sending email...!!!";

	public EmailNotSendException() {
		
	}	
	
	
	public EmailNotSendException(String message) {
		super();
		this.message = message;
	}


	@Override
	public String getMessage() {
		return message;
	}
	
	
}
