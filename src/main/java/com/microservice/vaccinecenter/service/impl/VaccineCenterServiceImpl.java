package com.microservice.vaccinecenter.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.microservice.vaccinecenter.entity.CowinUser;
import com.microservice.vaccinecenter.entity.VaccineCenter;
import com.microservice.vaccinecenter.external.service.CowinUserService;
import com.microservice.vaccinecenter.repository.VaccineCenterRepository;
import com.microservice.vaccinecenter.service.VaccineCenterService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class VaccineCenterServiceImpl implements VaccineCenterService {
	@Autowired
	private VaccineCenterRepository vaccineRepo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private CowinUserService cowinUserService;
    
	@Override
	public List<VaccineCenter> getAllCenters() {
		List<VaccineCenter> centers=vaccineRepo.findAll();
	    for(VaccineCenter center:centers) {
	    	List<CowinUser> users=cowinUserService.getUsers(center.getVaccineCenterId());
	    			//restTemplate.getForObject("http://CITIZEN-SERVICE/cowin-user/vaccine-center/" +center.getVaccineCenterId(), List.class);
	    	center.setUsers(users);
	    }
		return centers;
	}
	@HystrixCommand(fallbackMethod= "handleCitizenServiceFailure")
	@Override
	public VaccineCenter getSingleCenter(int vaccineCenterId) {
		
		VaccineCenter center=vaccineRepo.findById(vaccineCenterId).orElseThrow();
		List<CowinUser> users=cowinUserService.getUsers(vaccineCenterId);
				//restTemplate.getForObject("http://CITIZEN-SERVICE/cowin-user/vaccine-center/"+center.getVaccineCenterId(), List.class);
		center.setUsers(users);
		return center;
	}
	public VaccineCenter handleCitizenServiceFailure(int vaccineCenterId) {
		VaccineCenter center=vaccineRepo.findById(vaccineCenterId).orElseThrow();
		center.setUsers(null);
		return center;
	}
	@Override
	public VaccineCenter createCenter(VaccineCenter vaccineCenter) {
	
		return vaccineRepo.save(vaccineCenter);
	}

}
