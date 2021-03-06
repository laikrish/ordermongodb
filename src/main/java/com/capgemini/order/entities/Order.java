package com.capgemini.order.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


@Document(collection = "orderstable")
public class Order {
	@Id
	private int orderId;
	private int products;
	private int customerId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate orderDate;

	public Order(int orderId, int products, int customerId, LocalDate orderDate) {
		super();
		this.orderId = orderId;
		this.products = products;
		this.customerId = customerId;
		this.orderDate = orderDate;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProducts() {
		return products;
	}

	public void setProducts(int products) {
		this.products = products;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", products=" + products + ", customerId=" + customerId + ", orderDate="
				+ orderDate + "]";
	}

}
