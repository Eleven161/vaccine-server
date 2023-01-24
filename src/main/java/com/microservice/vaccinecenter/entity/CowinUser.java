package com.microservice.vaccinecenter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CowinUser {
	
	private String adhaarNumber;
	private String name;
	private String address;


}
