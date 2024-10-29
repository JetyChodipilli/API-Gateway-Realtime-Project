package com.jt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.entity.Inventory;

public interface InventryRepo extends JpaRepository<Inventory, String> {

}
