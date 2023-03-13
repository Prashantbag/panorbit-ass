package com.ty.world.WorldGenie.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID",length = 11)
	private int id;
	
	@NotNull
	@Column(name="Name",columnDefinition = "char(35) default ''")
	private char name;
	
	@Column(name = "CountryCode",columnDefinition = "char(3) default ''")
	@NotNull
	private char countrycode;
	
	@NotNull
	@Column(name="District",columnDefinition = "char(20) default ''")
	private char district;
	
	@NotNull
	@Column(name="Population",length = 11)
	private int population;
	
}
