package com.dnanh01.backend.service;

import org.springframework.stereotype.Service;

import com.dnanh01.backend.model.OrderItem;
import com.dnanh01.backend.repository.OrderItemRepository;

@Service
public class OrderItemServiceImplementation implements OrderItemService {

    private OrderItemRepository orderItemRepository;

    public OrderItemServiceImplementation(
            OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

}
