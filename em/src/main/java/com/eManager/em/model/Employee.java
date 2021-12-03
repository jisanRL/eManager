package com.eManager.em.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Serializable -> helps tranform the class into different type of string 

@Entity(name = "employee")
public class Employee implements Serializable {
	
	@Id
	@Column(name="ID")		 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@Column(name="Name")
	private String name;

	@Column(name="Email")
	private String email;
	
	@Column(name="Job_Title")
	private String jobTitle;
	
	@Column(name="Phone")
	private String phone;
	
	@Column(name="ImageURL")
	private String imageURL;
	
	@Column(name="EmployeeCode")		 
	private String employeeCode;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
