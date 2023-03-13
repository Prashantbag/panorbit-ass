package com.ty.world.WorldGenie.exception;

public class EmailNotFoundException extends RuntimeException {

	String message="Wrong Email ID.... You're not registered with World-Genie";

	
	public EmailNotFoundException() {

	}
	
	
	public EmailNotFoundException(String message) {
		super();
		this.message = message;
	}



	@Override
	public String getMessage() {
		return message;
	}
	
	
	
}
