package com.example.BestHospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BestHospital.entity.DoctorEntity;
import com.example.BestHospital.service.DoctorService;

@RestController
public class DoctorController {
	

	    @Autowired
	    private DoctorService service;
	    
	    @PostMapping("/Doctor")
	    public String addDoctor(@RequestBody DoctorEntity Doctor) {
	        return service.addDoctor(Doctor);}

	    @PutMapping("/Doctor/{id}/{salary}")
	    public DoctorEntity updateDoctor(@PathVariable int salary, @PathVariable int id, @RequestBody DoctorEntity Doctor) {
	        return service.updateDoctor(Doctor, salary);
	    }

	    @GetMapping("/Doctor")
	    public List<DoctorEntity> getAllDoctor(){
	        return service.getDoctor();
	    }
	    
	    @ExceptionHandler(value = com.example.BestHospital.exception.DoctorExist.class)
		public ResponseEntity<String> DoctorExist(
				com.example.BestHospital.exception.DoctorExist ExistExp) {
			return new ResponseEntity<String>("Doctor Id already exists!",HttpStatus.CONFLICT);

	    }
	}