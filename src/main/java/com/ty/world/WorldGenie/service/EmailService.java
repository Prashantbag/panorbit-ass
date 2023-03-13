package com.ty.world.WorldGenie.service;


import javax.mail.MessagingException;

import org.springframework.http.ResponseEntity;

import com.ty.world.WorldGenie.dto.EmailDetails;
import com.ty.world.WorldGenie.exception.EmailNotSendException;
import com.ty.world.WorldGenie.util.ResponseStructure;

public interface EmailService {

	 abstract ResponseEntity<ResponseStructure<String>> sendSimpleMail(EmailDetails details);

	abstract ResponseEntity<ResponseStructure<String>> sendMailWithAttachment(EmailDetails details)
			throws EmailNotSendException, MessagingException;
	 	    
}

