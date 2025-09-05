package com.cognizant.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.restaurant.entity.Allergen;

public interface AllergenRepository  extends JpaRepository<Allergen, Long>{

}
