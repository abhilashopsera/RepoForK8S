package com.example.BestHospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.BestHospital.entity.DoctorEntity;


public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer>{

		public DoctorEntity findByName(String name);
		
		@Query(value = "select id, name, salary, specialist from doctor order by salary desc, name asc", nativeQuery=true)
		public List<DoctorEntity> findAllBySalary();

}
