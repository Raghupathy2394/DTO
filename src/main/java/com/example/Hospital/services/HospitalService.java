package com.example.Hospital.services;

import java.util.ArrayList;
import java.util.List;
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
		// hospitaldto.setSalary(hospitalentity.getSalary());
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

	@Override
	public HospitalDTO update(HospitalDTO hospitaldto) {
		Hospital hospital1 = new Hospital(); // convert into dto
		hospital1.setId(hospitaldto.getId());
		hospital1.setName(hospitaldto.getName());
		hospital1.setSalary(hospitaldto.getSalary());
		hospital1.setWork(hospitaldto.getWork());
		hospitalRepo.save(hospital1);
		return hospitaldto;
	}

	@Override
	public String delete(int id) {
		hospitalRepo.deleteById(id);
		return "delete";
	}

	@Override
	public HospitalDTO getname(String name) {
		Optional<Hospital> hospital = hospitalRepo.findByName(name);
		Hospital hospital1 = hospital.get();
		HospitalDTO dto = new HospitalDTO();
		dto.setName(hospital1.getName());
		dto.setId(hospital1.getId());
		dto.setWork(hospital1.getWork());
		dto.setSalary(hospital1.getSalary());

		return dto;
	}

	@Override
	public List<HospitalDTO> getall() {
		List<Hospital> getall = hospitalRepo.findAll();
		List<HospitalDTO> dto = new ArrayList<>();
		for (Hospital h : getall) {
			HospitalDTO hostdto = new HospitalDTO();
			hostdto.setId(h.getId());
			hostdto.setName(h.getName());
			hostdto.setWork(h.getWork());
			hostdto.setSalary(h.getSalary());
			dto.add(hostdto);
		}
		return dto;
	}

	@Override
	public List<HospitalDTO> createall(List<HospitalDTO> hospitaldto) {
	List<Hospital> hospital=hospitalRepo.saveAll(hospitaldto);
	List<HospitalDTO> dto=new ArrayList<>();
	for(Hospital h:hospital) {
		HospitalDTO hostdto=new HospitalDTO();
		hostdto.setId(h.getId());
		hostdto.setName(h.getName());
		hostdto.setWork(h.getWork());
		hostdto.setSalary(h.getSalary());
		dto.add(hostdto);
	} return dto;
		
	} 
}
