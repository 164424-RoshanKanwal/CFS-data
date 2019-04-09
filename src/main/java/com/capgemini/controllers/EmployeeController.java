package com.capgemini.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.exception.AlreadyEmployeeExistException;
import com.capgemini.exception.EmployeeNotExistException;
import com.capgemini.model.Employee;
import com.capgemini.model.LoginCredentials;
import com.capgemini.model.StatusResponse;


@RestController
public class EmployeeController {
	
	
	@Autowired
	private MongoTemplate mongoTemplate;

	
	//returns employee object from employee collection that matches the id
	
	
	
	@PostMapping("/employee/{empId}")
	public ResponseEntity<Employee> getUserById(@PathVariable long empId, @RequestBody LoginCredentials loginCredentials) {
		
		Employee employee = mongoTemplate.findById(empId, Employee.class);
		System.out.println(employee);
		
		if(employee == null) {
			throw new EmployeeNotExistException("Employee Does Not Exist");
		}
		
		else if(employee.getEmpId() == loginCredentials.getEmpId() && employee.getPassword().equals(loginCredentials.getPassword()))  {
			
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("message","Success");
			return new ResponseEntity<>(employee, responseHeaders, HttpStatus.OK);
			}
		
		else {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("message","Username or Password is inValid");
			Employee emp = new Employee();
			return new ResponseEntity<>(emp, responseHeaders, HttpStatus.OK);
		}
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	//save the provided employee object in employee collection and returns same object back
	@PostMapping("/employee")
	public ResponseEntity<StatusResponse> saveEmployee(@RequestBody Employee newEmployee) {
		
		Employee employee=mongoTemplate.findById(newEmployee.getEmpId(), Employee.class);
		
		if(employee!=null) {
			System.out.println("Before Throwing");
			throw new AlreadyEmployeeExistException("Already Employee Exist");
		}
	
		StatusResponse statusResponse = new StatusResponse(HttpStatus.OK.value(), "Successfully Inserted");
		employee=mongoTemplate.save(newEmployee);
		return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
	
		}
	
}

