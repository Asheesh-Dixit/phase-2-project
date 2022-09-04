package com.flyaway.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.flyaway.dto.Airline;
import com.flyaway.dto.Destination;
import com.flyaway.dto.Flight;
import com.flyaway.dto.Source;
import com.flyaway.dto.User;

//import com.simplilearn.hibernate.webappdemo.dto.Student;

public class HibernateUtil {
	private static SessionFactory factory;
	
	public static SessionFactory getSessionFactory() {
		if(factory == null) {
			Configuration configuration = new Configuration();
			
			Properties properties = new Properties();
			
			properties.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/db");
			properties.setProperty(Environment.USER, "root");
			properties.setProperty(Environment.PASS, "Essel@123");
			properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			
			properties.setProperty(Environment.SHOW_SQL, "true");
			properties.setProperty(Environment.HBM2DDL_AUTO, "update");
			
			configuration.setProperties(properties);
			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(Airline.class);
			configuration.addAnnotatedClass(Source.class);
			configuration.addAnnotatedClass(Destination.class);
			configuration.addAnnotatedClass(Flight.class);
			
			ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			factory = configuration.buildSessionFactory(registry);
			//return factory;
		}
		
		return factory;
	}
}
