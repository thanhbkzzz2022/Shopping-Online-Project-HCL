package com.shopping.hibernate.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shopping.model.Bill;
import com.shopping.util.HibernateUtil;

public class BillDAO {
	
	private SessionFactory factory;
	
	public BillDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	public Bill find(Long id) {
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Bill bill = (Bill) session.createQuery("from Bill where id=:ID").setLong("ID", id).uniqueResult();
		
		transaction.commit();
		
		session.close();
		
		return bill != null ? bill : null;
	}
	
	public List<Bill> listAll() {
		
		List<Bill> list = new ArrayList<Bill>();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Bill order by id");
		
		list = query.list();
		
		transaction.commit();
		
		session.close();
		
		return list;
	}
	
	public String insert(Bill bill) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Bill p = (Bill) session.get(Bill.class, bill.getId());
		
		if(p == null) {
			session.save(bill);
			transaction.commit();
			res = "Insert Success";
			session.close();
		}
		
		return res;
	}
	
	public String update(Bill bill) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Bill b = (Bill) session.get(Bill.class, bill.getId());
		
		if(b != null) {
			b.setAddress(bill.getAddress());
			b.setDate(bill.getDate());
			b.setId_user(bill.getId_user());
			b.setName(bill.getName());
			b.setPhoneNumber(bill.getPhoneNumber());
			b.setStatus(bill.getStatus());
			b.setTotal(bill.getTotal());
			
			
			transaction.commit();
			
			res = "Update Success";

			session.close();
		}
		else {
			res = "Update Fail";
		}
		
		return res;
	}
	
	public String delete(Bill bill) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Bill b = (Bill) session.get(Bill.class, bill.getId());
		
		if(b != null) {
			session.delete(bill);
			
			transaction.commit();
			
			res = "Delete Success";
			
			session.close();
		}
		else {
			res = "Bill does not exist in Database";
		}
		
		return res;
	}
	
	
}

