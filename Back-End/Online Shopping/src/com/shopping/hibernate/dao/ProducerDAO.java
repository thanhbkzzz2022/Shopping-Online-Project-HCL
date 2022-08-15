package com.shopping.hibernate.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shopping.model.Producer;
import com.shopping.util.HibernateUtil;

public class ProducerDAO {
	
	private SessionFactory factory;
	
	public ProducerDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	public Producer find(Long id) {
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Producer producer = (Producer) session.createQuery("from Producer where id=:ID").setLong("ID", id).uniqueResult();
		
		transaction.commit();
		
		session.close();
		
		return producer != null ? producer : null;
	}
	
	public List<Producer> listAll() {
		
		List<Producer> list = new ArrayList<Producer>();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Producer order by id");
		
		list = query.list();
		
		transaction.commit();
		
		session.close();
		
		return list;
	}
	
	public String insert(Producer producer) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Producer p = (Producer) session.get(Producer.class, producer.getId());
		
		if(p == null) {
			session.save(producer);
			transaction.commit();
			res = "Insert Success";
			session.close();
		}
		
		return res;
	}
	
	public String update(Producer producer) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Producer p = (Producer) session.get(Producer.class, producer.getId());
		
		if(p != null) {
			p.setName(producer.getName());
			
			
			transaction.commit();
			
			res = "Update Success";

			session.close();
		}
		else {
			res = "Update Fail";
		}
		
		return res;
	}
	
	public String delete(Producer producer) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Producer r = (Producer) session.get(Producer.class, producer.getId());
		
		if(r != null) {
			session.delete(producer);
			
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
