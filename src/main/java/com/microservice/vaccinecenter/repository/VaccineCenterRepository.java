package com.microservice.vaccinecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.vaccinecenter.entity.VaccineCenter;

public interface VaccineCenterRepository extends JpaRepository<VaccineCenter, Integer> {

}
