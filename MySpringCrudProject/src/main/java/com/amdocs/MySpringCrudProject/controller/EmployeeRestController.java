package com.amdocs.MySpringCrudProject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.MySpringCrudProject.entity.Employee;
import com.amdocs.MySpringCrudProject.exception.EmployeeNotFoundException;
import com.amdocs.MySpringCrudProject.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeeService employeeService;
	//Constructor Injection
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee>findAll() {
        List<Employee> employees = employeeService.findAll();
		return employees;
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		
		if(employee==null) {
			throw new EmployeeNotFoundException("Employee Id "+employeeId + " Not Found!!");
		}
		
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		Employee employee = employeeService.save(theEmployee);
		return employee;
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		Employee employee = employeeService.save(theEmployee);
		return employee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public void deleteById(@PathVariable int employeeId) {
		employeeService.deleteById(employeeId);
	}
}