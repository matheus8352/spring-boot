package com.example.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}