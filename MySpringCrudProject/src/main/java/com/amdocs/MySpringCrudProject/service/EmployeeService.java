package com.amdocs.MySpringCrudProject.service;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.amdocs.MySpringCrudProject.entity.Employee;

//@CrossOrigin("http://localhost:56975")
public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int theId);
	public Employee save(Employee theEmployee);
	public void deleteById(int theId);
}
