package com.example.Category_Opretion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Category_Opretion.Dao.ProductDAO;
import com.example.Category_Opretion.Entity.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO dao;

	public List<Product> getAllProduct() {
		
		return dao.getAllProduct();
	}

	public Product createProduct(Product product) {
		
		return dao.createProduct( product);
		
		
	}

	public List<Product> getProductById(List<Long> id) {
		
		return dao.getProductById(id);
	}

	public Product updateProduct(Product productDetails) {
		
		return dao. updateProduct(productDetails);
		
	}

	public String deleteProduct(long id) {
		
		return dao.deleteProduct(id);
	}
	
	
	

}
