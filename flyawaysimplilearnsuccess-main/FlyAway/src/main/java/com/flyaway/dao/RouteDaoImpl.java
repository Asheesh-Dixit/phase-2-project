package com.flyaway.dao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flyaway.dto.Route;
import com.flyaway.util.HibernateUtil;

public class RouteDaoImpl implements RouteDao{
	private SessionFactory factory;
	
	public RouteDaoImpl() {
		factory = new HibernateUtil().getSessionFactory();
	}
	@Override
	public Integer addRoute(Route route) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Integer id = (Integer) session.save(route);
		
		txn.commit();
		session.close();
		return id;
	}

	@Override
	public void updateRoute(int id, String source, String destination, String src, String dsnt) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		// 1. retrieve the object with the specified roll no
		Route route = session.get(Route.class, id);
		System.out.println("Before updation : " + route);
		// 2. update the object using setter method
		route.setSource(source);
		route.setDestination(destination);
		route.setSrc(src);
		route.setDsnt(dsnt);
		System.out.println("After updation : " + route);
		// 3. send the object back to the DB table
		session.update(route);
		
		txn.commit();
		session.close();
	}

	@Override
	public void deleteRoute(int id) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Route route = session.get(Route.class, id);
		session.delete(route);
		
		txn.commit();
		session.close();
	}

	@Override
	public Set<Route> getAllRoutes() {
		Set<Route> allStudents = null;
		// select * from Routedata;
		String hql = "from Route";
		
		Session session = factory.openSession();
		TypedQuery<Route> typedQuery = session.createQuery(hql);
		allStudents =  (new HashSet<Route>(typedQuery.getResultList()));
		
		session.close();
		return allStudents;	
		}

}
