package com.shopping.hibernate.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shopping.model.Cart;
import com.shopping.util.HibernateUtil;

public class CartDAO {
	
	private SessionFactory factory;
	
	public CartDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	public Cart find(Long id) {
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Cart cart = (Cart) session.createQuery("from Cart where id=:ID").setLong("ID", id).uniqueResult();
		
		transaction.commit();
		
		session.close();
		
		return cart != null ? cart : null;
	}
	
	public List<Cart> listAll() {
		
		List<Cart> list = new ArrayList<Cart>();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Cart order by id");
		
		list = query.list();
		
		transaction.commit();
		
		session.close();
		
		return list;
	}
	
	public String insert(Cart cart) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Cart p = (Cart) session.get(Cart.class, cart.getId());
		
		if(p == null) {
			session.save(cart);
			transaction.commit();
			res = "Insert Success";
			session.close();
		}
		
		return res;
	}
	
	public String update(Cart cart) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Cart c = (Cart) session.get(Cart.class, cart.getId());
		
		if(c != null) {
			c.setCount(cart.getCount());
			c.setDate(cart.getDate());
			c.setId_user(cart.getId_user());
			
			
			transaction.commit();
			
			res = "Update Success";

			session.close();
		}
		else {
			res = "Update Fail";
		}
		
		return res;
	}
	
	public String delete(Cart cart) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Cart r = (Cart) session.get(Cart.class, cart.getId());
		
		if(r != null) {
			session.delete(cart);
			
			transaction.commit();
			
			res = "Delete Success";
			
			session.close();
		}
		else {
			res = "Cart does not exist in Database";
		}
		
		return res;
	}
	
	
}

