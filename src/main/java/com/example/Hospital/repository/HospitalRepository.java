package com.example.Hospital.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Hospital.DTO.HospitalDTO;
import com.example.Hospital.Entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

	Optional<Hospital> findByName(String name);

	List<Hospital> saveAll(List<HospitalDTO> hospitaldto);

}
