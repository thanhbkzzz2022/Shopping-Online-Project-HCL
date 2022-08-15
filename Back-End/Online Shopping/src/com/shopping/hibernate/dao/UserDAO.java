package com.shopping.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shopping.model.User;
import com.shopping.util.HibernateUtil;

public class UserDAO {
	
	private SessionFactory factory;
	
	public UserDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	public User find(Long id) {
		
		User userFind = new User();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		User user = (User) session.createQuery("from User where id=:ID").setLong("ID", id).uniqueResult();
		
		transaction.commit();
		
		session.close();
		
		return user != null ? user : null;
	}
	
	public List<User> listAll() {
		
		List<User> list = new ArrayList<User>();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from User order by id");
		
		list = query.list();
		
		transaction.commit();
		
		session.close();
		
		return list;
	}
	
	public String insert(User user) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		User u = (User) session.get(User.class, user.getId());
		
		if(u == null) {
			session.save(user);
			transaction.commit();
			res = "Insert Success";
			session.close();
		}
		
		return res;
	}
	
	public String update(User user) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		User u = (User) session.get(User.class, user.getId());
		
		if(u != null) {
			u.setUsername(user.getUsername());
			u.setAddress(user.getAddress());
			u.setEmail(user.getEmail());
			u.setFullName(user.getFullName());
			u.setPassword(user.getPassword());
			u.setPhoneNumber(user.getPhoneNumber());
			u.setType(user.getType());
			
			transaction.commit();
			
			res = "Update Success";

			session.close();
		}
		else {
			res = "Update Fail";
		}
		
		return res;
	}
	
	public String delete(User user) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		User u = (User) session.get(User.class, user.getId());
		
		if(u != null) {
			session.delete(user);
			
			transaction.commit();
			
			res = "Delete Success";
			
			session.close();
		}
		else {
			res = "User does not exist in Database";
		}
		
		return res;
	}
	
	
}
