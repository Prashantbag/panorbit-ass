package com.ty.world.WorldGenie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.world.WorldGenie.dao.SearchDao;
import com.ty.world.WorldGenie.dto.City;
import com.ty.world.WorldGenie.exception.WrongOtpFoundException;
import com.ty.world.WorldGenie.util.ResponseStructure;

@Service
public class SearchService {

	@Autowired
	SearchDao searchDao;
	
	public ResponseEntity<ResponseStructure<List<City>>> getCityByName(String city){
		ResponseStructure<List<City>> responseStructure= new ResponseStructure<List<City>>();
		
		
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("all city");
			responseStructure.setData(searchDao.getAllCity());
			
	return new ResponseEntity<ResponseStructure<List<City>>>(responseStructure,HttpStatus.OK);
		
		
	}
}
