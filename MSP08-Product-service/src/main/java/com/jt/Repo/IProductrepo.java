package com.jt.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.Entity.Product;

public interface IProductrepo extends JpaRepository<Product, Long> {

}
