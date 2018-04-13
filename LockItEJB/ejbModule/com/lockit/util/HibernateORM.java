package com.lockit.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateORM {
	
	
	private static HibernateORM hibernateObject = null;
	private Configuration configuration = null;
	private SessionFactory sessionFactory = null;
	
	
	private HibernateORM() {
		
	}
	
	
	public static HibernateORM getInstance() {
		if(hibernateObject == null) {
			hibernateObject = new HibernateORM();
		}
		
		return hibernateObject;
	}
	
	    
	public SessionFactory getSessionFactory() {
		
		configuration = new Configuration();  
		configuration.configure("hibernate.cfg.xml");
	    
	    sessionFactory = configuration.buildSessionFactory();  
		return sessionFactory;       
	}

}
