package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.OrderEntity;

@Repository
public interface OrderDao extends JpaRepository<OrderEntity, Integer> {

	@Query
	public OrderEntity findById(String id);
}
