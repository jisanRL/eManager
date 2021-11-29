package com.eManager.em.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="testTable")
public class Test_table {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)  // gonna be an auto incremental generation of the ID
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="country")
	private String country;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
