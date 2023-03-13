package com.ty.world.WorldGenie.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.world.WorldGenie.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> wrongOtpFoundExceptionHandler(WrongOtpFoundException exception){
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		
		responseStructure.setStatus(HttpStatus.UNAUTHORIZED.value());
		responseStructure.setMessage("OTP does not match");
		responseStructure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> emailNotSendExceptionHandler(EmailNotSendException exception){
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Email not found in DB");
		responseStructure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> er = ex.getAllErrors();
		
		Map<String,String> map = new LinkedHashMap<String, String>();
		
		for (ObjectError objectError : er) {
			
			String message=objectError.getDefaultMessage();
			String fieldname= ((FieldError)objectError).getField();
			map.put(message, fieldname);
		}
		
		
		ResponseStructure<Map<String,String>>  responseStructure = new ResponseStructure<Map<String,String>>();
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage("No Proper Input");
		responseStructure.setData(map);
		
		
		return new ResponseEntity<>(responseStructure,HttpStatus.BAD_REQUEST);
	}
}
