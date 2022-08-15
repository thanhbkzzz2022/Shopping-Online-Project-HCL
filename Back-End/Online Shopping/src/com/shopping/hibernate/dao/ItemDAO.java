package com.shopping.hibernate.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shopping.model.Item;
import com.shopping.util.HibernateUtil;

public class ItemDAO {
	
	private SessionFactory factory;
	
	public ItemDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	public Item find(Long id) {
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Item itemBill = (Item) session.createQuery("from Item where id=:ID").setLong("ID", id).uniqueResult();
		
		transaction.commit();
		
		session.close();
		
		return itemBill != null ? itemBill : null;
	}
	
	public List<Item> listAll() {
		
		List<Item> list = new ArrayList<Item>();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from ItemBill order by id");
		
		list = query.list();
		
		transaction.commit();
		
		session.close();
		
		return list;
	}
	
	public String insert(Item item) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Item p = (Item) session.get(Item.class, item.getId());
		
		if(p == null) {
			session.save(item);
			transaction.commit();
			res = "Insert Success";
			session.close();
		}
		
		return res;
	}
	
	public String update(Item item) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Item i = (Item) session.get(Item.class, item.getId());
		
		if(i != null) {
			i.setDescribe(item.getDescribe());
			i.setId_category(item.getId_category());
			i.setId_producer(item.getId_producer());
			i.setId_shop(item.getId_shop());
			i.setImg(item.getImg());
			i.setName(item.getName());
			i.setPrice(item.getPrice());
			i.setReleaseDate(item.getReleaseDate());
			i.setSaled(item.getSaled());
			
			
			transaction.commit();
			
			res = "Update Success";

			session.close();
		}
		else {
			res = "Update Fail";
		}
		
		return res;
	}
	
	public String delete(Item item) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Item i = (Item) session.get(Item.class, item.getId());
		
		if(i != null) {
			session.delete(item);
			
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

