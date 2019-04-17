package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.example.demo.dto.EmployeeRecord;
import com.example.demo.repository.QueryRepository2;

@RestController  
public class SpringBootJdbcController2 {
	
	@Autowired
	QueryRepository2 queryRepository2;
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/getAllUsers")
	@ResponseBody
	public List<EmployeeRecord> getAllUsers(){
		List<EmployeeRecord> employeeRecrod = queryRepository2.findAll(new Sort(Sort.Direction.DESC, "name"));
		return employeeRecrod;
	}
   
}
