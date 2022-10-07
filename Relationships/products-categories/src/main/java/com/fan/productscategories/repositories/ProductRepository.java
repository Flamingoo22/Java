package com.fan.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fan.productscategories.models.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product,Long>{
	
	List<Product> findAll();
}
