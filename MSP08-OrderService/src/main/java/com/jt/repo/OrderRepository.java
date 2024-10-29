package com.jt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
