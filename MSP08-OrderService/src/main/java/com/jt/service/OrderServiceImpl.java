package com.jt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.repo.OrderRepository;
import com.nt.entity.Order;
@Service("OrderService")
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private OrderRepository repo;
	

	@Override
	public String addOrder(Order order) {
		// TODO Auto-generated method stub
		System.out.println("Order id before order::"+order.getProductId());
		Order od=repo.save(order);
		return "Oder orderd with id::"+order.getProductId();
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		List<Order> it=repo.findAll();
		return null;
	}

	@Override
	public Optional<Order> findOrderById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
		
	}

	@Override
	public String deleteOrderById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Order> it=repo.findById(id);
		if(it.isPresent()) {
			repo.deleteById(id);
			return "Order deleted"+id;
		}
		else
		return "Order not founded"+id;
	}

}
