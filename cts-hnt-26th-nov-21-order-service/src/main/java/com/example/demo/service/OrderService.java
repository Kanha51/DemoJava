package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.OrderDto;

public interface OrderService {

	public OrderDto createOrder(OrderDto orderDto);

	public List<OrderDto> displayAllOrders();

	public OrderDto fetchOrderById(String id);
}
