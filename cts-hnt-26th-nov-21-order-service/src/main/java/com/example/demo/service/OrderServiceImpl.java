package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderDao;
import com.example.demo.dto.OrderDto;
import com.example.demo.entity.OrderEntity;
import com.example.demo.exception.IdNotFoundException;

@Service
public class OrderServiceImpl implements OrderService {
	private ModelMapper modelMapper;
	private OrderDao orderDao;

	public OrderServiceImpl(ModelMapper modelMapper, OrderDao orderDao) {
		this.modelMapper = modelMapper;
		this.orderDao = orderDao;
	}

	@Override
	public OrderDto createOrder(OrderDto orderDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		OrderEntity userEntity = modelMapper.map(orderDto, OrderEntity.class);
		OrderEntity temp = orderDao.save(userEntity);
		return modelMapper.map(temp, OrderDto.class);
	}

	@Override
	public List<OrderDto> displayAllOrders() {
		List<OrderEntity> orderEntityList = orderDao.findAll();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<OrderDto> orderDtoList = new ArrayList<>();
		Iterator<OrderEntity> iterator = orderEntityList.iterator();
		while (iterator.hasNext()) {
			orderDtoList.add(modelMapper.map(iterator.next(), OrderDto.class));
		}
		return orderDtoList;
	}

	@Override
	public OrderDto fetchOrderById(String id) {
		OrderEntity userEntity = orderDao.findById(id);
		if (userEntity == null) {
			throw new IdNotFoundException("id not found");
		}
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(orderDao.findById(id), OrderDto.class);
	}

}
