package com.example.Category_Opretion.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Category_Opretion.Entity.Category;
import com.example.Category_Opretion.Entity.Product;

@Repository
public class ProductDAO {
	
	@Autowired
	private SessionFactory factory;
	
	public List<Product> getAllProduct() {
		Session session=null;
		List<Product> list=null;
		try {
			session=factory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			list = criteria.list();
		} catch (Exception e) {
		e.printStackTrace();
		}
		finally {
			session.close();
		}
		return list;
	}

	public Product createProduct(Product product) {
	
		Session session=null;
		Product s=null;
		
		try {
			session=factory.openSession();
			Transaction beginTransaction = session.beginTransaction();
		
			session.save(product);
			beginTransaction.commit();
			s=product;
			
			
		} catch (Exception e) {
		    e.printStackTrace();
		}
		finally {
			session.close();
		}    
		    
	
		return s;
	
	

}

	public List<Product> getProductById(List<Long> id) {
		Session session = null;
		List<Product> list= null;
		try {
			session = factory.openSession();
			list = session.byMultipleIds(Product.class).multiLoad(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public Product updateProduct(Product productDetails) {
		Session session = null;
		Product s = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(productDetails);
			transaction.commit();
			s = productDetails;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return s;
	}

	public String deleteProduct(long id) {
		Session session = null;
		String msg = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Product category = session.get(Product.class, id);

			if (category != null) {
				session.delete(category);
				transaction.commit();
				msg = "Deleted !!";
			} else {
				msg = "Not Exists !!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return msg;
	}
}


