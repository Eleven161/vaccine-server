package com.microservice.vaccinecenter.service;

import java.util.List;
import com.microservice.vaccinecenter.entity.VaccineCenter;

public interface VaccineCenterService {

	List<VaccineCenter> getAllCenters();
	VaccineCenter getSingleCenter(int vaccineCenterId);
	VaccineCenter createCenter(VaccineCenter vaccineCenter);
}
