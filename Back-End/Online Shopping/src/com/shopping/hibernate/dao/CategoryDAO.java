package com.shopping.hibernate.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shopping.model.Category;
import com.shopping.util.HibernateUtil;

public class CategoryDAO {
	
	private SessionFactory factory;
	
	public CategoryDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	public Category find(Long id) {
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Category category = (Category) session.createQuery("from Category where id=:ID").setLong("ID", id).uniqueResult();
		
		transaction.commit();
		
		session.close();
		
		return category != null ? category : null;
	}
	
	public List<Category> listAll() {
		
		List<Category> list = new ArrayList<Category>();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Category order by id");
		
		list = query.list();
		
		transaction.commit();
		
		session.close();
		
		return list;
	}
	
	public String insert(Category category) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Category p = (Category) session.get(Category.class, category.getId());
		
		if(p == null) {
			session.save(category);
			transaction.commit();
			res = "Insert Success";
			session.close();
		}
		
		return res;
	}
	
	public String update(Category category) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Category c = (Category) session.get(Category.class, category.getId());
		
		if(c != null) {
			c.setName(category.getName());
			
			
			transaction.commit();
			
			res = "Update Success";

			session.close();
		}
		else {
			res = "Update Fail";
		}
		
		return res;
	}
	
	public String delete(Category category) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Category i = (Category) session.get(Category.class, category.getId());
		
		if(i != null) {
			session.delete(category);
			
			transaction.commit();
			
			res = "Delete Success";
			
			session.close();
		}
		else {
			res = "Category does not exist in Database";
		}
		
		return res;
	}
	
	
}

