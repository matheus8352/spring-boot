package com.example.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}