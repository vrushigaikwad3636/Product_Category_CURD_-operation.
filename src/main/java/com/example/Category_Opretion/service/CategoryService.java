package com.example.Category_Opretion.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Category_Opretion.Dao.CategoryDAO;
import com.example.Category_Opretion.Entity.Category;



@Service
public class CategoryService {

	 @Autowired
	    private CategoryDAO categoryDAO;

	public List<Category> getAllCategory() {
		
		return categoryDAO.getAllCategory();
	}

	public Category createCategory(Category category) {
		
		return categoryDAO.createCategory(category);
	}

	public List<Category> getCategoryById(List<Long> id) {
		
		return categoryDAO.getALLStudentsByID(id);
	}

	public Category updateCategory(Category categoryDetails) {
		
		return categoryDAO.updateCategory(categoryDetails);
	}

	public String deleteCategory(long id) {
		
		return categoryDAO.deleteCategory(id);
	}

	 

		

		
	}

