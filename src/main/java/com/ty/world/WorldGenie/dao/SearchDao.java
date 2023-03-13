package com.ty.world.WorldGenie.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.world.WorldGenie.dto.City;
import com.ty.world.WorldGenie.repository.CityRepository;

@Repository
public class SearchDao {

	@Autowired
	CityRepository cityRepository;
	
	public List<City> getAllCity(){
		return cityRepository.findAll();
	}
}
