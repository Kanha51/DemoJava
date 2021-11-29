package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "order_table")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Integer orderId;
	@Column(name = "unique_id", unique = true, nullable = false)
	private String id;
	@Column(name = "order_name", unique = true, nullable = false)
	private String orderName;
	@Column(name = "order_price", unique = true, nullable = false)
	private Double orderPrice;

	public OrderEntity(Integer orderId, String id, String orderName, Double orderPrice) {
		this.orderId = orderId;
		this.id = id;
		this.orderName = orderName;
		this.orderPrice = orderPrice;
	}

}
