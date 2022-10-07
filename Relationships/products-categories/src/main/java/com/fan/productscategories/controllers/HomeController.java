package com.fan.productscategories.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.fan.productscategories.models.Category;
import com.fan.productscategories.models.Product;
import com.fan.productscategories.services.CategoryService;
import com.fan.productscategories.services.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private CategoryService cateServ;
	
	@Autowired
	private ProductService productServ;
	
	@GetMapping("")
	public String showAll(
			Model model
			) {
		model.addAttribute("products", this.productServ.showAll());
		model.addAttribute("categories", this.cateServ.showAll());
		return "index.jsp";
	}
	
	@GetMapping("/products/new")
	public String newProduct(
			@ModelAttribute("product")Product product
			) {
		return "/products/new.jsp";
	}
	
	@GetMapping("/categories/new")
	public String newCategory(
			@ModelAttribute("category")Category category
			) {
		return"/categories/new.jsp";
	}
	
	@PostMapping("/products/new")
	public String newProduct(
			@Valid @ModelAttribute("product")Product product,
			BindingResult result,
			Model model
			) {
		if(result.hasErrors()) {
			model.addAttribute("product",product);
			return"/products/new.jsp";
		}
		this.productServ.create(product);
		return "redirect:/";
	}
	
	@PostMapping("/categories/new")
	public String newCategory(
			@Valid @ModelAttribute("category")Category category,
			BindingResult result,
			Model model
			) {
		if(result.hasErrors()) {
			model.addAttribute("category",category);
			return"/categories/new.jsp";
		}
		this.cateServ.create(category);
		return "redirect:/";
	}
	
	@GetMapping("/products/{id}")
	public String productAddCategory(
			@PathVariable("id")Long product_id,
			Model model
			) {
		Product product = this.productServ.showOne(product_id);
		model.addAttribute("product", product);
		List<Category>allCategory = this.cateServ.showAll();
		ArrayList<Category> categoryNotInProduct = new ArrayList<Category>();
		for(Category category : allCategory) {
			if(!product.getCategories().contains(category)) {
				categoryNotInProduct.add(category);
			}
		}
		model.addAttribute("categories", categoryNotInProduct);
		return "/products/showOne.jsp";
	}

	@GetMapping("/categories/{id}")
	public String categoryAddProduct(
			@PathVariable("id")Long category_id,
			Model model
			) {
		Category category = this.cateServ.showOne(category_id);
		model.addAttribute("category", category);
		List<Product> allProduct = this.productServ.showAll();
		ArrayList<Product> productNotInCategory = new ArrayList<Product>();
		for(Product product : allProduct) {
			if(!category.getProducts().contains(product)) {
				productNotInCategory.add(product);
			}
		}
		model.addAttribute("products", productNotInCategory);
		return "/categories/showOne.jsp";
	}
	
	@PutMapping("/products/{id}")
	public String productAddCategory(
			@PathVariable("id")Long product_id,
			@ModelAttribute("categories")Long category_id
			) {
		Category category = this.cateServ.showOne(category_id);
		Product product = this.productServ.showOne(product_id);
		product.getCategories().add(category);
//		category.getProducts().add(product);
		this.productServ.create(product);
//		this.cateServ.create(category);
		return "redirect:/products/"+product_id;
	}
	
	@PutMapping("/categories/{id}")
	public String categoryAddProduct(
			@PathVariable("id")Long category_id,
			@ModelAttribute("products")Long product_id
			) {
		Product product = this.productServ.showOne(product_id);
		Category category = this.cateServ.showOne(category_id);
		category.getProducts().add(product);
//		product.getCategories().add(category);
		this.cateServ.create(category);
//		this.productServ.create(product);
		return "redirect:/categories/"+category_id;
	}
}
