package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderDto;
import com.example.demo.service.OrderService;
import com.example.demo.ui.OrderRequestModel;
import com.example.demo.ui.OrderResponseModel;

@RestController
public class HomeController {

	private Environment environment;
	private OrderService orderService;
	private ModelMapper modelMapper;

	public HomeController(Environment environment, OrderService orderService, ModelMapper modelMapper) {
		this.environment = environment;
		this.orderService = orderService;
		this.modelMapper = modelMapper;
	}

	@GetMapping("/")
	public ResponseEntity<String> getStatus() {
		return ResponseEntity.ok("order-ws is up and running on port: " + environment.getProperty("local.server.port"));
	}

	@PostMapping("/orders")
	public ResponseEntity<OrderResponseModel> createOrder(@RequestBody OrderRequestModel orderRequestModel) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		OrderDto orderDto = modelMapper.map(orderRequestModel, OrderDto.class);
		String str[] = UUID.randomUUID().toString().split("-");
		orderDto.setId(str[0]);
		OrderDto temp = orderService.createOrder(orderDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(temp, OrderResponseModel.class));
	}

	@GetMapping("/orders")
	public ResponseEntity<List<OrderResponseModel>> displayOrders() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<OrderDto> orderDtoList = orderService.displayAllOrders();
		List<OrderResponseModel> orderResponseModelList = new ArrayList<>();
		Iterator<OrderDto> iterator = orderDtoList.iterator();
		while (iterator.hasNext()) {
			orderResponseModelList.add(modelMapper.map(iterator.next(), OrderResponseModel.class));
		}
		return ResponseEntity.ok(orderResponseModelList);
	}

	@GetMapping("/orders/{id}")
	public ResponseEntity<OrderResponseModel> fetOrderById(@PathVariable("id") String id) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		return ResponseEntity.ok(modelMapper.map(orderService.fetchOrderById(id), OrderResponseModel.class));
	}
}
