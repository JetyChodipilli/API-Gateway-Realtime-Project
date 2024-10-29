package com.jt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.Entity.Product;
import com.jt.Repo.IProductrepo;
@Service
public class ProductService implements IProductSevice {
	@Autowired
	private IProductrepo repo; 

	@Override
	public String registerProduct(Product product) {
		// TODO Auto-generated method stub
		System.out.println("Product Id::"+product.getId());
		Product prod=repo.save(product);
		return "Product svaed By Id"+product.getId();
	}

	@Override
	public Optional<Product> findById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> it=repo.findAll();
		return it;
	}

	@Override
	public String deleteById(Long id) {
		// TODO Auto-generated method stub
		Optional<Product> list=repo.findById(id);
		if(list.isPresent()) {
			repo.deleteById(id);
			return "Product is Deleted"+id;
		}
		else
		 return "product is not available"+id;
	}

	@Override
	public String updateProduct(Product product) {
		// TODO Auto-generated method stub
		Optional<Product> it=repo.findById(product.getId());
		if(it.isPresent()) {
			repo.save(product);
			return "Product is Updated::"+product.getId();
		}
		else
		 return "Product is Not Found"+product.getId();
	}


}
