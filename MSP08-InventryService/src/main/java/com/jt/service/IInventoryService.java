package com.jt.service;

import java.util.List;
import java.util.Optional;

import com.jt.entity.Inventory;

public interface IInventoryService {
	public List<Inventory> getAllInventory();
	public Optional<Inventory> getById(String productId);
	public String updateInventory(Inventory inv);

}
