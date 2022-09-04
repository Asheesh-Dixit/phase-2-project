package com.flyaway.dao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flyaway.dto.Airline;
import com.flyaway.dto.Destination;
import com.flyaway.util.HibernateUtil;

public class DestinationDaoImpl implements DestinationDao{
	private SessionFactory factory;
	
	public DestinationDaoImpl() {
		factory = new HibernateUtil().getSessionFactory();
	}
	@Override
	public Integer addDestination(Destination destination) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Integer id = (Integer) session.save(destination);
		
		txn.commit();
		session.close();
		return id;
	}

	@Override
	public void updateDestination(int id, String city,  String dsnt) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		// 1. retrieve the object with the specified id
		Destination destination = session.get(Destination.class, id);
		System.out.println("Before updation : " + destination);
		// 2. update the object using setter method
		destination.setDestination(city);
		destination.setDsnt(dsnt);
		System.out.println("After updation : " + destination);
		// 3. send the object back to the DB table
		session.update(destination);
		
		txn.commit();
		session.close();
	}

	@Override
	public void deleteDestination(int id) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Destination destination = session.get(Destination.class, id);
		session.delete(destination);
		
		txn.commit();
		session.close();
	}
	
	@Override
	public Destination getDestinationById(int id) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Destination destination = session.get(Destination.class, id);
		return destination;
	}

	@Override
	public Set<Destination> getAllDestinations() {
		Set<Destination> allStudents = null;
		// select * from Destinationdata;
		String hql = "from Destination";
		
		Session session = factory.openSession();
		TypedQuery<Destination> typedQuery = session.createQuery(hql);
		allStudents =  (new HashSet<Destination>(typedQuery.getResultList()));
		
		session.close();
		return allStudents;	
		}

}
