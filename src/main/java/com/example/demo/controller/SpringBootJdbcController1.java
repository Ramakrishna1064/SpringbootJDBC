package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeRecord;
import com.example.demo.model.StatusObject;
import com.example.demo.repository.QueryRepository1;

@RestController  
public class SpringBootJdbcController1 {  
	
    @Autowired  
    JdbcTemplate jdbc;    
    
    @Autowired
	QueryRepository1 queryRepository1;
    
    @RequestMapping("/insert")  
    public String index(){  
    	System.out.println("Hello Rama");
        jdbc.execute("insert into user(name,email)values('javatpoint','java@javatpoint.com')");  
        return"data inserted Successfully";  
    }  


	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getFilmUSer", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public EmployeeRecord getFilmUser(@RequestBody EmployeeRecord filmDTO) {
		System.out.println("emplooyee id--->"+filmDTO.getName());
		//EmployeeRecord record = queryRepository1.findUserId(filmDTO.getId(),filmDTO.getName());
		//EmployeeRecord record = queryRepository1.findByLikeOperator(filmDTO.getName());
		EmployeeRecord record = queryRepository1.findUserName(filmDTO.getId(),filmDTO.getName());
		return record;
	}
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/updateUSer", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public StatusObject updateUser(@RequestBody EmployeeRecord filmDTO) {
		System.out.println("emplooyee id--->"+filmDTO.getName());
		int record = queryRepository1.updateUser(filmDTO.getName(),filmDTO.getEmail());
		StatusObject statusObject = new StatusObject();
		if(record!=-1) {
			statusObject.setStatus(true);
			statusObject.setMessage("User updated Successfully");
		}else {
			statusObject.setStatus(false);
			statusObject.setMessage("Fail to update user");
		}
		return statusObject;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/deleteUSer", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public StatusObject deleteUser(@RequestBody EmployeeRecord filmDTO) {
		System.out.println("emplooyee id--->"+filmDTO.getName());
		int record = queryRepository1.deleteUser(filmDTO.getId());
		StatusObject statusObject = new StatusObject();
		if(record!=-1) {
			statusObject.setStatus(true);
			statusObject.setMessage("User delete Successfully");
		}else {
			statusObject.setStatus(false);
			statusObject.setMessage("Fail to delete user");
		}
		return statusObject;
	}
}  