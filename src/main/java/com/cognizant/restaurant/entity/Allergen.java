package com.cognizant.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Allergen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "item_id")
	@JsonIgnore
	private Item item;
	
	
	public Allergen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Allergen(String name) {
		super();
		this.name = name;
	}
	
	public Allergen(String name, Item item) {
		super();
		this.name = name;
		this.item = item;
	}

	public Long getId() {
		return id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "Allergen [name=" + name + "]";
	}
	
}
