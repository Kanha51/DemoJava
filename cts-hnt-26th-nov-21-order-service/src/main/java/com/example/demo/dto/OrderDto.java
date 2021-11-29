package com.example.demo.dto;

public class OrderDto {
	private String id;
	private String orderName;
	private Double orderPrice;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	/**
	 * @param id
	 * @param orderName
	 * @param orderPrice
	 */
	public OrderDto(String id, String orderName, Double orderPrice) {
		super();
		this.id = id;
		this.orderName = orderName;
		this.orderPrice = orderPrice;
	}

	public OrderDto() {
		super();

	}

}
