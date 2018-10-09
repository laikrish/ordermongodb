package com.capgemini.order.service;


import java.util.List;

import com.capgemini.order.entities.Order;
import com.capgemini.order.exception.OrderAlreadyExistsException;
import com.capgemini.order.exception.OrderDoesnotExistsException;



public interface OrderService {
	public Order addOrder(Order order) throws OrderAlreadyExistsException;

	public void deleteOrder(Order order) throws OrderDoesnotExistsException;

	public Order findOrderById(int orderId) throws OrderDoesnotExistsException;

	public List<Order> findOrderByCustomerId(int customerId) throws OrderDoesnotExistsException;


	public List<Order> getAllOrders();

}