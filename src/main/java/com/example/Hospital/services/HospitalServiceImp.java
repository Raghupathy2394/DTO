package com.example.Hospital.services;

import java.util.List;

import com.example.Hospital.DTO.HospitalDTO;

public interface HospitalServiceImp {

	HospitalDTO getdetails(int id);

	HospitalDTO create(HospitalDTO hospitaldto);

	HospitalDTO update(HospitalDTO hospitaldto);

	String delete(int id);

	HospitalDTO getname(String name); 

	List<HospitalDTO> getall();

	List<HospitalDTO> createall(List<HospitalDTO> hospitaldto);


}
