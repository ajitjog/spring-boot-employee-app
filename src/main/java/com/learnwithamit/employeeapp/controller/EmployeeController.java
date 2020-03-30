package com.learnwithamit.employeeapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithamit.employeeapp.model.Employee;
import com.learnwithamit.employeeapp.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeeController {
	
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployeeDetails() {
		return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/employees/{employeeId}")
	public ResponseEntity<Employee> getEmployeeDetailByEmployeeId(@PathVariable int employeeId) {
		 Optional<Employee> data = employeeRepository.findById(employeeId);
		 if(data.isPresent())
			 return new ResponseEntity<Employee>(data.get(), HttpStatus.OK);
		 else
			 return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<?> addNewEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int employeeId) {
		employeeRepository.deleteById(employeeId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}












