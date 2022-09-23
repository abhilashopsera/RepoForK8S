package com.example.BestHospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BestHospital.entity.DoctorEntity;
import com.example.BestHospital.exception.DoctorExist;


@Service
public class DoctorImpl implements DoctorService{
		
		@Autowired
		private com.example.BestHospital.repository.DoctorRepository DoctorRepository;
		
		@Override
		public String addDoctor(DoctorEntity Doctor) {
			DoctorEntity clearDocData = DoctorRepository.findByName(Doctor.getName());
			if (clearDocData == null)
			{
				DoctorRepository.save(Doctor);
				return "New Doctor Added to the Database";}
			else 
				throw new DoctorExist ("Doctor Data Already Existed in the Database");
		}

		@Override
		public DoctorEntity updateDoctor(DoctorEntity Doctor, int id)
		{
			java.util.Optional<DoctorEntity> ed = DoctorRepository.findById(id);
			DoctorEntity eda = ed.get();
			eda.setName(Doctor.getName());
			eda.setSalary(Doctor.getSalary());
			eda.setSpecialist(Doctor.getSpecialist());
			DoctorRepository.save(eda);
			return eda;}
		
		@Override
		public List<DoctorEntity> getDoctor(){
			return DoctorRepository.findAllBySalary();}
		}