package com.ty.world.WorldGenie.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.Data;

@Data
@Entity
public class Country {
	
	@Column(name="Code",columnDefinition = "char(3) default ''")
	@NotNull
	@Id
	private char code;
	
	@Column(name = "Name",columnDefinition = "char(52) default ''")
	@NotNull
	private char name;
	
	@Enumerated
	@Column(name = "Continent",columnDefinition = "Continent default Asia")
	@NotNull
	private Continent continent;
	
	@Column(name = "Region",columnDefinition = "char(26) default ''")
	@NotNull
	private char region;
	
	@Column(name = "SurfaceArea",columnDefinition = "float(10,2) default 0.00")
	@NotNull
	private float surfaceArea;
	
	@Column(name = "IndepYear",columnDefinition = "smallint(6) default")
	@Null
	private int indepYear;
	
	@Column(name = "Population",columnDefinition = "int(11) default 0")
	@NotNull
	private int population;
	
	@Column(name = "LifeExpectancy",columnDefinition = "float(3,1) default")
	@Null
	private float lifeExpectancy;
	
	@Column(name = "GNP",columnDefinition = "float(10,2) default")
	@Null
	private float gnp;
	
	@Column(name = "GNPOld",columnDefinition = "float(10,2) default")
	@Null
	private float gnpOld;
	
	@Column(name = "LocalName",columnDefinition = "char(45) default ''")
	@NotNull
	private char localName;
	
	@Column(name = "GovernmentFOrm",columnDefinition = "char(45) default ''")
	@NotNull
	private char governmentForm;
	
	@Column(name = "HeadOfState",columnDefinition = "char(60) default")
	@Null
	private char headOfState;
	
	@Column(name = "Capital",columnDefinition = "int(11) default")
	@Null
	private int capital;
	
	@Column(name = "Code2",columnDefinition = "char(2) default ''")
	@NotNull
	private char code2;
}
