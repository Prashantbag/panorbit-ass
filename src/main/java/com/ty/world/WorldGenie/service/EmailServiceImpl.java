package com.ty.world.WorldGenie.service;

import java.io.File;
import java.util.Optional;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ty.world.WorldGenie.dao.UserDao;
import com.ty.world.WorldGenie.dto.EmailDetails;
import com.ty.world.WorldGenie.dto.User;
import com.ty.world.WorldGenie.exception.EmailNotFoundException;
import com.ty.world.WorldGenie.exception.EmailNotSendException;
import com.ty.world.WorldGenie.util.ResponseStructure;


@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}") 
	private String sender;
	
	@Autowired
	public HttpSession httpSession;
	
	@Autowired
	UserDao userDao;

	@Override
	public ResponseEntity<ResponseStructure<String>> sendSimpleMail(EmailDetails details) throws EmailNotSendException  {
	
			 
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            
            Optional<User> existingUser= userDao.getUserByEmail(details.getRecipient());
            
            if(existingUser.isPresent()) {
            	Random random=new Random();
        		int rand=random.nextInt(225000);
        		httpSession.setAttribute("otp", rand);
        		
        		
                mailMessage.setFrom(sender);
                mailMessage.setTo(details.getRecipient());
                mailMessage.setText("Hello\n"
                		+ "You OTP is "+rand);
                mailMessage.setSubject("Generated OTP for World Genie User Login");
                
                ResponseStructure<String> responseStructure= new ResponseStructure<String>();
                
                responseStructure.setStatus(HttpStatus.OK.value());
                responseStructure.setMessage("Mail Sent Successfully...");
                responseStructure.setData("Mail Sent");
                
                javaMailSender.send(mailMessage);
                javaMailSender.send(mailMessage);
                
                return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
            }else {
            	throw new EmailNotFoundException();
            }
            
		
	}
	
	@Override
	public ResponseEntity<ResponseStructure<String>> sendMailWithAttachment(EmailDetails details)throws EmailNotSendException, MessagingException {
		
		MimeMessage mimeMessage= javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		
         mimeMessageHelper= new MimeMessageHelper(mimeMessage, true);
         mimeMessageHelper.setFrom(sender);
         mimeMessageHelper.setTo(details.getRecipient());
         mimeMessageHelper.setText(details.getMsgBody());
         mimeMessageHelper.setSubject(details.getSubject());

         FileSystemResource file= new FileSystemResource(new File(details.getAttachment()));

         mimeMessageHelper.addAttachment(file.getFilename(), file);

         ResponseStructure<String> responseStructure= new ResponseStructure<String>();
         
         responseStructure.setStatus(HttpStatus.OK.value());
         responseStructure.setMessage("Mail with attachment Sent Successfully...");
         responseStructure.setData("Mail Sent");
         
         
         javaMailSender.send(mimeMessage);
         return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
     

    
	} 
}
