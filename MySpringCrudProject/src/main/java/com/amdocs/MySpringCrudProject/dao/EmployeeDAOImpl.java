package com.amdocs.MySpringCrudProject.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amdocs.MySpringCrudProject.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private EntityManager entityManager;
	
	public EmployeeDAOImpl(EntityManager theEntityManager) {
			this.entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
			// Getting the current session of Hibernate
			Session currentSession = 
					entityManager.unwrap(Session.class);
			Query<Employee> theQuery = 
					currentSession.createQuery("From Employee",Employee.class);
			List<Employee> employees = theQuery.getResultList();
			//System.out.println(employees);
			return employees;
		
	}
	
	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		// Getting the current session of Hibernate
		Session currentSession = 
				entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, theId);
					
		return employee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		// Getting the current session of Hibernate
		Session currentSession = 
				entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theEmployee);
		return theEmployee;
	}

	@Override
	public void deleteById(int employeeId) {
		// TODO Auto-generated method stub
		// Getting the current session of Hibernate
		Session currentSession = 
				entityManager.unwrap(Session.class);
		
		// Deleting the object by Id
		Query<Employee> theQuery = 
				currentSession.createQuery("Delete From Employee where id=:empId");
		theQuery.setParameter("empId", employeeId);
		theQuery.executeUpdate();
	}

}