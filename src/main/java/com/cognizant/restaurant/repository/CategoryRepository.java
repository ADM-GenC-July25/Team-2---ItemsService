package com.cognizant.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.restaurant.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
