package com.flyaway.dao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flyaway.dto.Airline;
import com.flyaway.dto.Source;
import com.flyaway.util.HibernateUtil;

public class SourceDaoImpl implements SourceDao{
	private SessionFactory factory;
	
	public SourceDaoImpl() {
		factory = new HibernateUtil().getSessionFactory();
	}
	@Override
	public Integer addSource(Source source) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Integer id = (Integer) session.save(source);
		
		txn.commit();
		session.close();
		return id;
	}

	@Override
	public void updateSource(int id, String city, String src) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		// 1. retrieve the object with the specified id
		Source source = session.get(Source.class, id);
		System.out.println("Before updation : " + source);
		// 2. update the object using setter method
		source.setSource(city);
		source.setSrc(src);

		System.out.println("After updation : " + source);
		// 3. send the object back to the DB table
		session.update(source);
		
		txn.commit();
		session.close();
	}

	@Override
	public void deleteSource(int id) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Source source = session.get(Source.class, id);
		session.delete(source);
		
		txn.commit();
		session.close();
	}
	
	@Override
	public Source getSourceById(int id) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Source source = session.get(Source.class, id);
		return source;
	}

	@Override
	public Set<Source> getAllSources() {
		Set<Source> allStudents = null;
		// select * from Sourcedata;
		String hql = "from Source";
		
		Session session = factory.openSession();
		TypedQuery<Source> typedQuery = session.createQuery(hql);
		allStudents =  (new HashSet<Source>(typedQuery.getResultList()));
		
		session.close();
		return allStudents;	
		}

}
