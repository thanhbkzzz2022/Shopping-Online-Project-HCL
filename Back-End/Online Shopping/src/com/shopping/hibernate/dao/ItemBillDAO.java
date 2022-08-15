package com.shopping.hibernate.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shopping.model.ItemBill;
import com.shopping.util.HibernateUtil;

public class ItemBillDAO {
	
	private SessionFactory factory;
	
	public ItemBillDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	public ItemBill find(Long id) {
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		ItemBill itemBill = (ItemBill) session.createQuery("from ItemBill where id=:ID").setLong("ID", id).uniqueResult();
		
		transaction.commit();
		
		session.close();
		
		return itemBill != null ? itemBill : null;
	}
	
	public List<ItemBill> listAll() {
		
		List<ItemBill> list = new ArrayList<ItemBill>();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from ItemBill order by id");
		
		list = query.list();
		
		transaction.commit();
		
		session.close();
		
		return list;
	}
	
	public String insert(ItemBill itemBill) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		ItemBill p = (ItemBill) session.get(ItemBill.class, itemBill.getId());
		
		if(p == null) {
			session.save(itemBill);
			transaction.commit();
			res = "Insert Success";
			session.close();
		}
		
		return res;
	}
	
	public String update(ItemBill itemBill) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		ItemBill i = (ItemBill) session.get(ItemBill.class, itemBill.getId());
		
		if(i != null) {
			i.setId_bill(itemBill.getId_bill());
			i.setId_item(itemBill.getId_bill());
			i.setName(itemBill.getName());
			
			
			transaction.commit();
			
			res = "Update Success";

			session.close();
		}
		else {
			res = "Update Fail";
		}
		
		return res;
	}
	
	public String delete(ItemBill itemBill) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		ItemBill i = (ItemBill) session.get(ItemBill.class, itemBill.getId());
		
		if(i != null) {
			session.delete(itemBill);
			
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

