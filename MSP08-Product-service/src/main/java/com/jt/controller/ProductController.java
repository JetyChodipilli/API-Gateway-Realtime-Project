package com.jt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.Entity.Product;
import com.jt.service.IProductSevice;

import jakarta.ws.rs.core.Response;

@RestController
@RequestMapping("/product-api")
public class ProductController {
	@Autowired
	private IProductSevice service;
	
	@GetMapping("/showAll")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> all=service.getAllProducts();
		return new ResponseEntity<List<Product>>(all,HttpStatus.OK);
	}
	@PostMapping("/register")
	public ResponseEntity<String> registerProduct(@RequestBody Product product){
		try {
			String msg=service.registerProduct(product);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Product>> findById(@PathVariable Long id){
		try {
			Optional<Product> it=service.findById(id);
			return new ResponseEntity<Optional<Product>>(it,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Optional<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
		@GetMapping("/delete/{id}")
		public ResponseEntity<String> deleteById(@PathVariable Long id){
			try {
				String it=service.deleteById(id);
				return new ResponseEntity<String>(it,HttpStatus.OK);
			}
			catch(Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		@PutMapping("/modify")
		public ResponseEntity<String> updateProduct(@RequestBody Product product){
			try {
				String msg=service.updateProduct(product);
				return new ResponseEntity<String>(msg,HttpStatus.OK);
			}
			catch(Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
		}

}
