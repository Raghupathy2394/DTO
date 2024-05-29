package com.example.Hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@GetMapping("/getall")
	public List<HospitalDTO> getall(){
	return hospitalService.getall();
}
	
	@GetMapping("/getname/{name}")
	public HospitalDTO getname(@PathVariable("name") String name) {
		return hospitalService.getname(name);
	}

	@PostMapping("/post")
	public HospitalDTO create(@RequestBody HospitalDTO hospitaldto) {
		return hospitalService.create(hospitaldto);
	}
 @PostMapping("/postall")
 public List<HospitalDTO> createall(@RequestBody List<HospitalDTO> hospitaldto){
	 return hospitalService.createall(hospitaldto);
 }
	
	@PutMapping("/put")
	public HospitalDTO update(@RequestBody HospitalDTO hospitaldto) {
		return hospitalService.update(hospitaldto);
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return hospitalService.delete(id);
	} 
}
