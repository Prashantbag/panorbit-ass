package com.ty.world.WorldGenie.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class CountryLanguage {

	@Id
	@Column(name="CountryCode",columnDefinition = "char(3) default ''")
	@NotNull
	private char countryCode;
	
	@Column(name="Language",columnDefinition = "char(30) default ''")
	@NotNull
	private char language;
	
	@Column(name="IsOfficial",columnDefinition = "IsOfficial default F")
	@NotNull
	private IsOfficial isOfficial;
	
	@Column(name="Percentage",columnDefinition = "float(4,1) default 0.0")
	@NotNull
	private float percentage;
}
