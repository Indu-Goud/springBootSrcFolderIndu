package com.employeerestboot.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeerestboot.services.model.Employee;
import com.employeerestboot.services.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	
	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeRepo.save(employee);
		return savedEmployee;
	}
	
	@GetMapping("/employee/{eid}")
	public Employee getEmployeeById(@PathVariable int eid) {
		Employee foundEmployee = employeeRepo.findById(eid).orElse(new Employee());
		return foundEmployee;
		
	}
	
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		List<Employee> foundAllEmployee = employeeRepo.findAll();
		return foundAllEmployee;
	}
	
	
	@PutMapping("/employee")
	public Employee updateOrSaveEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeRepo.save(employee);
		return savedEmployee;
	}

	
	@DeleteMapping("/employee/{eid}")
	public String deleteEmployeeById(@PathVariable int eid) {
		employeeRepo.deleteById(eid);
		return "Deleted";
	}
	
	
	
}
