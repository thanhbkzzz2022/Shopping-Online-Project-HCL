package com.shopping.hibernate.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shopping.model.ItemCart;
import com.shopping.util.HibernateUtil;

public class ItemCartDAO {
	
	private SessionFactory factory;
	
	public ItemCartDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	public ItemCart find(Long id) {
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		ItemCart itemCart = (ItemCart) session.createQuery("from ItemCart where id=:ID").setLong("ID", id).uniqueResult();
		
		transaction.commit();
		
		session.close();
		
		return itemCart != null ? itemCart : null;
	}
	
	public List<ItemCart> listAll() {
		
		List<ItemCart> list = new ArrayList<ItemCart>();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from ItemCart order by id");
		
		list = query.list();
		
		transaction.commit();
		
		session.close();
		
		return list;
	}
	
	public String insert(ItemCart itemCart) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		ItemCart p = (ItemCart) session.get(ItemCart.class, itemCart.getId());
		
		if(p == null) {
			session.save(itemCart);
			transaction.commit();
			res = "Insert Success";
			session.close();
		}
		
		return res;
	}
	
	public String update(ItemCart itemCart) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		ItemCart i = (ItemCart) session.get(ItemCart.class, itemCart.getId());
		
		if(i != null) {
			i.setName(itemCart.getName());
			
			
			transaction.commit();
			
			res = "Update Success";

			session.close();
		}
		else {
			res = "Update Fail";
		}
		
		return res;
	}
	
	public String delete(ItemCart itemCart) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		ItemCart r = (ItemCart) session.get(ItemCart.class, itemCart.getId());
		
		if(r != null) {
			session.delete(itemCart);
			
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

