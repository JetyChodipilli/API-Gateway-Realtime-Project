package com.nt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.entity.Inventory;
import com.jt.service.IInventoryService;

@RestController
@RequestMapping("/inventory-api")
public class InventoryController {
	@Autowired
	private IInventoryService service;
	 
	@GetMapping("/all")
	public List<Inventory> getAllInventory(){
		return service.getAllInventory();
		
	}
	@GetMapping("/find/{productId}")
	public  Optional<Inventory> getInventoryById(@PathVariable String productId) {
		return service.getById(productId);
	}
	@PutMapping("/update/{productId}")
	public String updateInventory(@PathVariable String productId,@RequestBody Inventory inv) {
		return service.updateInventory(inv);
		
	}

}
