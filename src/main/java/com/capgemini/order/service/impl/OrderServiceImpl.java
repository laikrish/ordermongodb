package com.capgemini.order.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.order.entities.Order;
import com.capgemini.order.exception.OrderAlreadyExistsException;
import com.capgemini.order.exception.OrderDoesnotExistsException;
import com.capgemini.order.repository.OrderRepository;
import com.capgemini.order.service.OrderService;



@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order addOrder(Order order) throws OrderAlreadyExistsException {
		Optional<Order> orderFromDb = orderRepository.findById(order.getOrderId());
		if (!orderFromDb.isPresent()) {
			return orderRepository.save(order);
		}
		throw new OrderAlreadyExistsException("Order id " + order.getOrderId() + " is already done.");

	}

	@Override
	public void deleteOrder(Order order) throws OrderDoesnotExistsException {
		Optional<Order> orderFromDb = orderRepository.findById(order.getOrderId());
		if (orderFromDb.isPresent()) {
			orderRepository.delete(order);
			return;
		}
		throw new OrderDoesnotExistsException("Order id " + order.getOrderId() + " does not exists for deletion");
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order findOrderById(int orderId) throws OrderDoesnotExistsException {
		Optional<Order> orderFromDb = orderRepository.findById(orderId);
		if (orderFromDb.isPresent()) {
			return orderFromDb.get();
		}
		throw new OrderDoesnotExistsException("Order id " + orderId + " does not exists to search");
	}

	@Override
	public List<Order> findOrderByCustomerId(int customerId) throws OrderDoesnotExistsException {
		return orderRepository.findByCustomerId(customerId);

	}

}