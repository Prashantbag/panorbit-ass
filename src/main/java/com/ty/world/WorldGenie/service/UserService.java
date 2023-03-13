package com.ty.world.WorldGenie.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.world.WorldGenie.dao.UserDao;
import com.ty.world.WorldGenie.dto.User;
import com.ty.world.WorldGenie.exception.WrongOtpFoundException;
import com.ty.world.WorldGenie.util.ResponseStructure;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	
	@Autowired
	HttpSession httpSession;

	
	public ResponseEntity<ResponseStructure<String>> validateUser(String email,int password){
		int otp=(int) httpSession.getAttribute("otp");
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		
		if(password==otp) {
			responseStructure.setStatus(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("OTP is Correct");
			responseStructure.setData("User Logged in Succesfully");
			return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.ACCEPTED);
		}else {
			throw new WrongOtpFoundException();
		}
		
	}

	public ResponseEntity<ResponseStructure<User>> saveUser(User user){
		ResponseStructure<User> responseStructure= new ResponseStructure<User>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("User Created");
		responseStructure.setData(userDao.saveUser(user));
		
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
	}
	
	
}
