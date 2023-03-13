package com.ty.world.WorldGenie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ty.world.WorldGenie.dto.EmailDetails;
import com.ty.world.WorldGenie.service.EmailService;
import com.ty.world.WorldGenie.util.ResponseStructure;

@RestController
@RequestMapping("/user")
public class VerifyEmailController {

	@Autowired
	EmailService emailService;

	@PostMapping("/verify")
	public ModelAndView verifyUser(@ModelAttribute("emaildetail") EmailDetails details,BindingResult result){
		ResponseEntity<ResponseStructure<String>> response=emailService.sendSimpleMail(details);
		ModelAndView modelAndView= new ModelAndView();
		
		if(response.getStatusCodeValue()==200) {
			modelAndView.addObject("emaildetail",new EmailDetails());
			modelAndView.setViewName("loginuser.html");
		}
		return modelAndView;
	}
}
