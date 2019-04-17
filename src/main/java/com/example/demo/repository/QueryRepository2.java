package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.dto.EmployeeRecord;

@Repository
public interface QueryRepository2 extends JpaRepository<EmployeeRecord, Integer> {
	
}
