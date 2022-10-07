package com.fan.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fan.productscategories.models.Category;
import com.fan.productscategories.repositories.CategoryRepository;


@Service
public class CategoryService {


	@Autowired
	private CategoryRepository categoryRepo;
	
	
	public Category create(Category category) {
		return this.categoryRepo.save(category);
	}
	
	public List<Category> showAll() {
		return this.categoryRepo.findAll();
	}
	
	public Category showOne(Long category_id) {
		Optional<Category> category = this.categoryRepo.findById(category_id);
		return category.isPresent() ? category.get() : null;
	}
	
	
}
