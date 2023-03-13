package com.ty.world.WorldGenie.exception;

public class WrongOtpFoundException extends RuntimeException {
	
	String message= "Entered Wrong OTP";

	public WrongOtpFoundException() {
		
	}
	
	
	public WrongOtpFoundException(String message) {
		super();
		this.message = message;
	}




	@Override
	public String getMessage() {
		return message;
	}
	
	
}
