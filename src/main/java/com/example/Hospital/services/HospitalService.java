package com.example.Hospital.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hospital.DTO.HospitalDTO;
import com.example.Hospital.Entity.Hospital;
import com.example.Hospital.repository.HospitalRepository;

@Service
public class HospitalService implements HospitalServiceImp {

	@Autowired
	HospitalRepository hospitalRepo;

	@Override
	public HospitalDTO getdetails(int id) {
		Optional<Hospital> hospital = hospitalRepo.findById(id);
		Hospital hospitalentity = hospital.get();
		HospitalDTO hospitaldto = new HospitalDTO();
		hospitaldto.setId(hospitalentity.getId());
		 hospitaldto.setName(hospitalentity.getName());
		 hospitaldto.setSalary(hospitalentity.getSalary());
		hospitaldto.setWork(hospitalentity.getWork());
		return hospitaldto;
	}

	@Override
	public HospitalDTO create(HospitalDTO hospitaldto) {
		
		Hospital hospital = new Hospital();
		
		hospital.setName(hospitaldto.getName());
		hospital.setSalary(hospitaldto.getSalary());
		hospital.setWork(hospitaldto.getWork());
		 hospitalRepo.save(hospital);
		return hospitaldto;
	}

/*	@Override
	public HospitalDTO getname(String name) {
		Optional<Hospital> hospital=hospitalRepo.findByname(name);
		Hospital hospitalentity=hospital.get();
		HospitalDTO dto=new HospitalDTO();
		dto.setId(hospitalentity.getId());
		dto.setName(hospitalentity.getName());
		dto.setSalary(hospitalentity.getSalary());
		dto.setWork(hospitalentity.getWork());
		return dto;
	} */
}
