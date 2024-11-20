package com.example.Category_Opretion.Dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Category_Opretion.Entity.Category;


@Repository
public class CategoryDAO {

   @Autowired
   private SessionFactory factory;

public List<Category> getAllCategory() {
	Session session=null;
	List<Category> list = null;
	try {
		session = factory.openSession();

		Criteria criteria = session.createCriteria(Category.class);
		list = criteria.list();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		session.close();
	}
	return list;
}

public Category createCategory(Category category) {
	Session session = null;
	Category s = null;
	try {
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(category);
		transaction.commit();
		s = category;
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		session.close();
	}
	return s;
}

public List<Category> getALLStudentsByID(List<Long> id) {
	
	Session session = null;
	List<Category> list= null;
	try {
		session = factory.openSession();
		list = session.byMultipleIds(Category.class).multiLoad(id);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		session.close();
	}
	return list;
}

public Category updateCategory(Category categoryDetails) {
	Session session = null;
	Category s = null;
	try {
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(categoryDetails);
		transaction.commit();
		s = categoryDetails;
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		session.close();
	}
	return s;
}

public String deleteCategory(long id) {
	Session session = null;
	String msg = null;
	try {
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Category category = session.get(Category.class, id);

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
   
