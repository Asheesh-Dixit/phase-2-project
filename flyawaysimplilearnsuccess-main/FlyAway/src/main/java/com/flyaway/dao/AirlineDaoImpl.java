package com.flyaway.dao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flyaway.dto.Airline;
import com.flyaway.util.HibernateUtil;

public class AirlineDaoImpl implements AirlineDao{
	private SessionFactory factory;
	
	public AirlineDaoImpl() {
		factory = new HibernateUtil().getSessionFactory();
	}
	@Override
	public Integer addAirline(Airline airline) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Integer id = (Integer) session.save(airline);
		
		txn.commit();
		session.close();
		return id;
	}

	@Override
	public void updateAirline(int id, String name, String iata) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		// 1. retrieve the object with the specified roll no
		Airline airline = session.get(Airline.class, id);
		System.out.println("Before updation : " + airline);
		// 2. update the object using setter method
		airline.setName(name);
		airline.setIata(iata);
		System.out.println("After updation : " + airline);
		// 3. send the object back to the DB table
		session.update(airline);
		
		txn.commit();
		session.close();
	}

	@Override
	public void deleteAirline(int id) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Airline airline = session.get(Airline.class, id);
		session.delete(airline);
		
		txn.commit();
		session.close();
	}
	
	@Override
	public Airline getAirlineById(int id) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Airline airline = session.get(Airline.class, id);
		return airline;
	}

	@Override
	public Set<Airline> getAllAirlines() {
		Set<Airline> allAirlines = null;
		// select * from Airlinedata;
		String hql = "from Airline";
		
		Session session = factory.openSession();
		TypedQuery<Airline> typedQuery = session.createQuery(hql);
		allAirlines =  new HashSet<Airline>(typedQuery.getResultList());
		
		session.close();
		return allAirlines;	
	}

}
