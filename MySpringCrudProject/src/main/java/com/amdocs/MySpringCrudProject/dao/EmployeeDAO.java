package com.amdocs.MySpringCrudProject.dao;

import java.util.List;

import com.amdocs.MySpringCrudProject.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	public Employee findById(int theId);
	public Employee save(Employee theEmployee);
	public void deleteById(int employeeId);
}
