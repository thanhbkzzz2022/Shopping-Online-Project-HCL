package com.shopping.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shopping.model.Review;
import com.shopping.util.HibernateUtil;

public class ReviewDAO {
	
	private SessionFactory factory;
	
	public ReviewDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	public Review find(Long id) {
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Review review = (Review) session.createQuery("from Review where id=:ID").setLong("ID", id).uniqueResult();
		
		transaction.commit();
		
		session.close();
		
		return review != null ? review : null;
	}
	
	public List<Review> listAll() {
		
		List<Review> list = new ArrayList<Review>();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Review order by id");
		
		list = query.list();
		
		transaction.commit();
		
		session.close();
		
		return list;
	}
	
	public String insert(Review review) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Review r = (Review) session.get(Review.class, review.getId());
		
		if(r == null) {
			session.save(review);
			transaction.commit();
			res = "Insert Success";
			session.close();
		}
		
		return res;
	}
	
	public String update(Review review) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Review r = (Review) session.get(Review.class, review.getId());
		
		if(r != null) {
			r.setContent(review.getContent());
			r.setDate(review.getDate());
			r.setId_item(review.getId_item());
			r.setId_user(review.getId_user());
			
			
			transaction.commit();
			
			res = "Update Success";

			session.close();
		}
		else {
			res = "Update Fail";
		}
		
		return res;
	}
	
	public String delete(Review review) {
		
		String res = null;
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Review r = (Review) session.get(Review.class, review.getId());
		
		if(r != null) {
			session.delete(review);
			
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
