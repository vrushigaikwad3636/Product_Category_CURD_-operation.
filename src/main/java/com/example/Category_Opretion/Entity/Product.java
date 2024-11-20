package com.example.Category_Opretion.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    @ManyToOne
	    @JoinColumn(name = "category_id", nullable = false)
	    private Category category;

		public Product() {
			super();
			
		}

		public Product(Long id, String name, Category category) {
			super();
			this.id = id;
			this.name = name;
			this.category = category;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", category=" + category + "]";
		}
	
	    
	    
	
	

}
