package com.amdocs.MySpringCrudProject.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.amdocs.MySpringCrudProject.dao.EmployeeDAO;
import com.amdocs.MySpringCrudProject.entity.Employee;

@Service
// @CrossOrigin("http://localhost:4200")
public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO)
	{
		this.employeeDAO = theEmployeeDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeDAO.findAll();
		return employees;
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Employee employee = employeeDAO.findById(theId);
		return employee;
	}

	@Override
	@Transactional
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		Employee employee = employeeDAO.save(theEmployee);
		return employee;
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeDAO.deleteById(theId);

	}

}
