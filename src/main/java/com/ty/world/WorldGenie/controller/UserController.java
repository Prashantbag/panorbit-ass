package com.ty.world.WorldGenie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ty.world.WorldGenie.dto.EmailDetails;
import com.ty.world.WorldGenie.dto.User;
import com.ty.world.WorldGenie.service.UserService;
import com.ty.world.WorldGenie.util.ResponseStructure;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	

	
	@PostMapping("/save-user")
	public ModelAndView registerUser(@ModelAttribute User user) {
		ResponseEntity<ResponseStructure<User>> response=userService.saveUser(user);
		ModelAndView modelAndView= new ModelAndView();

		if(response.getStatusCodeValue()== 201) {
			modelAndView.addObject("emaildetail", new EmailDetails());
			modelAndView.addObject("userform", new User());
			modelAndView.setViewName("login.html");
		}
		return modelAndView;
	}
	

	
	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<String>> validateUser(@RequestParam String recipient,@RequestParam int password){
		return userService.validateUser(recipient, password);
	}
}
