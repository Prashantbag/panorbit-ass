package com.ty.world.WorldGenie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.world.WorldGenie.dto.EmailDetails;
import com.ty.world.WorldGenie.dto.User;

@Controller
public class MainController {
	
	@GetMapping("/greeting")
	public String greeting(){
		return "greeting";
	}
	
	@RequestMapping("/signup")
	public ModelAndView signupPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("signup.html");
		modelAndView.addObject("userform", new User());
		return modelAndView;	
	}

	@RequestMapping("/login")
	public ModelAndView loginPage() {
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("emaildetail",new EmailDetails());
		modelAndView.addObject("userform", new User());
		modelAndView.setViewName("login.html");
		return modelAndView;
	}
	
	@RequestMapping("/loginuser")
	public ModelAndView loginuserPage(Model model) {
		model.addAttribute("emaildetail",new EmailDetails());
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("emaildetail",new EmailDetails());
		modelAndView.setViewName("loginuser.html");
		return modelAndView;	
	}
	
	@RequestMapping("/dashboard")
	public ModelAndView userDashboard() {
		ModelAndView modelAndView= new ModelAndView();

		modelAndView.setViewName("dashboard.html");
		
		return modelAndView;
	}
}
