package com.example.Category_Opretion.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Category_Opretion.Entity.Category;
import com.example.Category_Opretion.service.CategoryService;




@RestController
@RequestMapping("/api/Categories")

public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public List<Category> getAllCategory(){
		return categoryService.getAllCategory();
	}
	
	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
	}
	
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable List<Long> id) {
		return (Category) categoryService.getCategoryById(id);
	}
	
	@PutMapping("/update-Categories")
	public Category updateCategory(@RequestBody Category categoryDetails) {

		return categoryService.updateCategory(categoryDetails);
	}
	
	@DeleteMapping("{id}")
	public String deleteCategory(@PathVariable long id) {
		return categoryService.deleteCategory(id);
	}

}
