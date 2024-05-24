package com.example.Hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hospital.DTO.HospitalDTO;
import com.example.Hospital.services.HospitalServiceImp;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	HospitalServiceImp hospitalService;

	@GetMapping("/get/{id}")
	public HospitalDTO getdetails(@PathVariable int id) {
		return hospitalService.getdetails(id);
	}
	
	//@GetMapping("/get/{name}")
	//public HospitalDTO getname(@RequestParam String name) {
	//	return hospitalService.getname(name);
	//}
	
	@PostMapping("/post")
	public HospitalDTO create(@RequestBody HospitalDTO hospitaldto) {
		return hospitalService.create(hospitaldto);
	}
}
