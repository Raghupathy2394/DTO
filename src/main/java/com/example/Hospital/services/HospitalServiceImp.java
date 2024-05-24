package com.example.Hospital.services;

import com.example.Hospital.DTO.HospitalDTO;

public interface HospitalServiceImp {

	HospitalDTO getdetails(int id);

	HospitalDTO create(HospitalDTO hospitaldto);

	HospitalDTO getname(String name);


}
