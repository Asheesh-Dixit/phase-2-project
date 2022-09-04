package com.flyaway.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flyaway.dto.Flight;
import com.flyaway.util.HibernateUtil;

public class FlightDaoImpl implements FlightDao{
	private SessionFactory factory;
	
	public FlightDaoImpl() {
		factory = new HibernateUtil().getSessionFactory();
	}
	@Override
	public Integer addFlight(Flight flight) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Integer id = (Integer) session.save(flight);
		
		txn.commit();
		session.close();
		return id;
	}

	@Override
	public void updateFlight(int id, String flight_name, String airline, String source, String destination, String time,
			String price) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		// 1. retrieve the object with the specified roll no
		Flight flight = session.get(Flight.class, id);
		System.out.println("Before updation : " + flight);
		// 2. update the object using setter method
		flight.setFlight_name(flight_name);
		flight.setAirline(airline);
		flight.setSource(source);
		flight.setDestination(destination);
		flight.setTime(time);
		flight.setPrice(price);
		System.out.println("After updation : " + flight);
		// 3. send the object back to the DB table
		session.update(flight);
		
		txn.commit();
		session.close();
	}

	@Override
	public void deleteFlight(int id) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Flight student = session.get(Flight.class, id);
		session.delete(student);
		
		txn.commit();
		session.close();
	}
	
	@Override
	public List<Flight> searchFlights(String source, String destination) {
		List<Flight> flights = null;
		Session session = factory.openSession();
		
		String hql = "FROM Flight where source = :source AND destination = : destination";
		TypedQuery<Flight> query = session.createQuery(hql);
		query.setParameter("source", source);
		query.setParameter("destination", destination);
		flights = query.getResultList();
		session.close();
		return flights;
	}

	@Override
	public List<Flight> getAllFlights() {
		List<Flight> allFlights = null;
		// select * from Flightdata;
		String hql = "from Flight";
		
		Session session = factory.openSession();
		TypedQuery<Flight> typedQuery = session.createQuery(hql);
		allFlights =  (typedQuery.getResultList());
		
		session.close();
		return allFlights;	
	}

}
