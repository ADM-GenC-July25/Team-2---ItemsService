package com.cognizant.restaurant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SpiceLevel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	public SpiceLevel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SpiceLevel(String name) {
		super();
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SpiceLevel [name=" + name + "]";
	}
	
	
}
