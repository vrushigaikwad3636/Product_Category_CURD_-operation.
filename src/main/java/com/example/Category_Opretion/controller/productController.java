package com.example.Category_Opretion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Category_Opretion.Entity.Category;
import com.example.Category_Opretion.Entity.Product;
import com.example.Category_Opretion.service.ProductService;

@RestController
@RequestMapping("/api/Product")
public class productController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> getAllCategory(){
		return productService.getAllProduct();
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable List<Long> id) {
		return (Product) productService.getProductById(id);
	}
	
	@PutMapping("/update-Product")
	public Product updateProduct(@RequestBody Product productDetails) {

		return productService.updateProduct(productDetails);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable long id) {
		return productService.deleteProduct(id);
	}

	
	
}
