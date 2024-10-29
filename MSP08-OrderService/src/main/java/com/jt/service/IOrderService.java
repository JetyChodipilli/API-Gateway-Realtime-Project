package com.jt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Order;

public interface IOrderService {
	public String addOrder(Order order);
	public List<Order> findAll();
	public Optional<Order> findOrderById(Integer id);
	public String deleteOrderById(Integer id);
}
