package com.fan.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fan.productscategories.models.Product;
import com.fan.productscategories.repositories.ProductRepository;


@Service
public class ProductService{

	@Autowired
	private ProductRepository productRepo;
	
	
	public Product create(Product product) {
		return this.productRepo.save(product);
	}
	
	public List<Product> showAll() {
		return this.productRepo.findAll();
	}
	
	public Product showOne(Long product_id) {
		Optional<Product> product = this.productRepo.findById(product_id);
		return product.isPresent() ? product.get() : null;
	}
	
	
}

