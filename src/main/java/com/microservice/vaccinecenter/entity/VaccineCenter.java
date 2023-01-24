package com.microservice.vaccinecenter.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VaccineCenter {
	@Id
	private int vaccineCenterId;
	private String name;
	private String address;
	@Transient
	private List<CowinUser> users;

}
