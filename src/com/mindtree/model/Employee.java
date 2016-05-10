package com.mindtree.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="employees")
@Entity
public class Employee {

	@Id
	@Column(name="EMP_MID")
	private String empId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="firstName")
	private String firstName;

	@Column(name="lastName")
	private String lastName;
	
	public Employee() {
		super();
	}
	
	

	public Employee(String empId, String email, String firstName, String lastName) {
		super();
		this.empId = empId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
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
	
}
