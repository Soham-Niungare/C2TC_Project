package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.repository.EmployeeRepository;
import com.app.services.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;
	@Autowired
	EmployeeRepository repo;
	
	@GetMapping("/employee")
	public List<Employee> list() {
		return service.listAll();
	}
	
	@PostMapping("/employee/add/{id}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody Employee employee) {
		repo.save(employee);
	}
	
	 @DeleteMapping("/employee/delete/{id}")
	 public void delete(@PathVariable Integer id) //extracting ID from the URL
	 {
		 repo.deleteById(id);
	 }
}
