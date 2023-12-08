package com.dnanh01.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnanh01.backend.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}