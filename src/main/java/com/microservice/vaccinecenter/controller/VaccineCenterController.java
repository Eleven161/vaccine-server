package com.microservice.vaccinecenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.vaccinecenter.entity.VaccineCenter;
import com.microservice.vaccinecenter.service.VaccineCenterService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/vaccine-center")
public class VaccineCenterController {
	//get single center by vaccine-center
	@Autowired
	private VaccineCenterService vaccineCenterService;
	@GetMapping("/greet")
	public String greet() {
		return "Hello Sunny";
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VaccineCenter> getSingleVaccineCenter(@PathVariable int id){
		
		return ResponseEntity.ok(vaccineCenterService.getSingleCenter(id));
	}
	//@HystrixCommand(fallbackMethod= "handleCitizenServiceFailure")
	@GetMapping
	public ResponseEntity<List<VaccineCenter>> getCenters(){
		return ResponseEntity.ok(vaccineCenterService.getAllCenters());
		
	}
	@PostMapping
	public ResponseEntity<VaccineCenter> createCenter(@RequestBody VaccineCenter center){
		return ResponseEntity.ok(vaccineCenterService.createCenter(center));
	}

}
