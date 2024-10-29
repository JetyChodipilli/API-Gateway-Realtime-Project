package com.jt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.entity.Inventory;
import com.jt.repo.InventryRepo;

@Service
public class InventoryService implements IInventoryService {
	@Autowired
	private InventryRepo repo;

	@Override
	public List<Inventory> getAllInventory() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Inventory> getById(String productId) {
		// TODO Auto-generated method stub
		return repo.findById(productId);
	}

	@Override
	public String updateInventory(Inventory inv) {
		Optional<Inventory> it=repo.findById(inv.getProductId());
		if(it.isPresent()) {
			repo.save(inv);
			return "Product is Updated::"+inv.getProductId();
		}
		else
		 return "Product is Not Found"+inv.getProductId();
	}

}
