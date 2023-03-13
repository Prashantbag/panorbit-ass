package com.ty.world.WorldGenie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.world.WorldGenie.dto.City;
import com.ty.world.WorldGenie.service.SearchService;
import com.ty.world.WorldGenie.util.ResponseStructure;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	SearchService searchService;
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<City>>> searchOnType(@RequestParam String search){
		return searchService.getCityByName(search);
	}
}
