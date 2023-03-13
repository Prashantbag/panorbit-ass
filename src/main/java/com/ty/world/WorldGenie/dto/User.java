package com.ty.world.WorldGenie.dto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	private String email;
	private String firstName;
	private String lastName;
	@Enumerated(EnumType.STRING)
	private Gender gender; 
	private long phoneno;
}
