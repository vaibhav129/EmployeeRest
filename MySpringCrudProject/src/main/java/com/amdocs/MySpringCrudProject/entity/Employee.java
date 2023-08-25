package com.amdocs.MySpringCrudProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //MySQL
    @Column(name="id")
    private int id;
    
    @Column(name="firstName")
    private String firstName;
    
    @Column(name="lastName")
    private String lastName;
    
    @Column(name="eMail")
    private String eMail;
    
    public Employee() {
        // Default constructor required by Hibernate
    }
    
    public Employee(int id, String firstName, String lastName, String eMail) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
