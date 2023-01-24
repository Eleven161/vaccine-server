package com.microservice.vaccinecenter.external.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.vaccinecenter.entity.CowinUser;

@FeignClient(name="CITIZEN-SERVICE")
public interface CowinUserService {
	
	@GetMapping("/cowin-user/vaccine-center/{vaccineCenterId}")
	List<CowinUser> getUsers(@PathVariable int vaccineCenterId );
//	@GetMapping("/cowin-user/{vaccineCenterId}")
//	CowinUser getUsers();
	

}
