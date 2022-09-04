package com.flyaway.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.flyaway.dto.User;
import com.flyaway.util.HibernateUtil;

public class UserDaoImpl implements UserDao{
	private SessionFactory factory;
	
	public UserDaoImpl() {
		factory = HibernateUtil.getSessionFactory();
	}
	

	@Override
	public boolean registerUser(User user) {
		
		boolean isUserRegistered = false;
		
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Integer id = (Integer) session.save(user);
		
		txn.commit();
		session.close();
		
		if(id > 0){
			isUserRegistered = true;
		}
		
		return isUserRegistered;
	}
	
	@Override
	public boolean validateUser(User user) {
		boolean isUserValid = false;
		
		Session session = factory.openSession();
		
		TypedQuery<User> typedQuery = session.createQuery("from User where username=:username and password=:password");
		typedQuery.setParameter("username", user.getUserName());
	    typedQuery.setParameter("password", user.getPassword());
        User user1=(User)(typedQuery.getSingleResult());
        
	    if(user1!=null) {
	    	isUserValid = true;
	    }
		
		session.close();
		
		return isUserValid;
	}
	
	public void updateAdminPassword(String username, String password) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		String hql = "FROM User where userName = :username";
		TypedQuery<User> query = session.createQuery(hql);
		query.setParameter("username", username);
		User user = query.getSingleResult();
		
		user.setPassword(password);
		
		session.update(user);
		txn.commit();
		session.close();
	}

}
