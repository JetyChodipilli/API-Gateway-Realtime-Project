package com.jt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.service.IOrderService;
import com.nt.entity.Order;

@RestController
@RequestMapping("/order-api")
public class OrderOperationController {
	@Autowired
	private IOrderService service;
	
	@PostMapping("/order")
	public String getOrderbyId(@RequestBody Order order) {
		return service.addOrder(order);
		
	}
	@GetMapping("/all")
	public List<Order> getAllOrders(){
		return service.findAll();
		
	}
	@GetMapping("order/{id}")
	public Optional<Order> getOrderById(@PathVariable Integer id) {
		return service.findOrderById(id);
		
	}
	@GetMapping("/delete/{id}")
	public String deleteOrderById(@PathVariable Integer id) {
		try {
			String msg=service.deleteOrderById(id);
			return "Order Removed Sucessfullly"+id;
		}
		catch(Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
