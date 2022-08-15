package com.shopping.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shopping.model.Shop;
import com.shopping.util.HibernateUtil;

public class ShopDAO {
	
	private SessionFactory factory;
	
	public ShopDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	public Shop find(Long id) {
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Shop shop = (Shop) session.createQuery("from Shop where id=:ID").setLong("ID", id).uniqueResult();
		
		transaction.commit();
		
		session.close();
		
		return shop != null ? shop : null;
	}
	
	public List<Shop> listAll() {
		
		List<Shop> list = new ArrayList<Shop>();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Shop order by id");
		
		list = query.list();
		
		transaction.commit();
		
		session.close();
		
		return list;
	}
	
	public String insert(Shop shop) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Shop s = (Shop) session.get(Shop.class, shop.getId());
		
		if(s == null) {
			session.save(shop);
			transaction.commit();
			res = "Insert Success";
			session.close();
		}
		
		return res;
	}
	
	public String update(Shop shop) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Shop s = (Shop) session.get(Shop.class, shop.getId());
		
		if(s != null) {
			s.setAddress(shop.getAddress());
			s.setDescribe(shop.getDescribe());
			s.setImg(shop.getImg());
			s.setName(shop.getName());
			s.setPhoneNumber(shop.getPhoneNumber());
			
			transaction.commit();
			
			res = "Update Success";

			session.close();
		}
		else {
			res = "Update Fail";
		}
		
		return res;
	}
	
	public String delete(Shop shop) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Shop s = (Shop) session.get(Shop.class, shop.getId());
		
		if(s != null) {
			session.delete(shop);
			
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
