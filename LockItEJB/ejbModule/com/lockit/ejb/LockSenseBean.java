package com.lockit.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lockit.entity.House;
import com.lockit.util.HibernateORM;

/**
 * Session Bean implementation class LockSenseBean
 */
@Stateless
@LocalBean
public class LockSenseBean implements LockSenseBeanRemote, LockSenseBeanLocal {

	HibernateORM hibernateObject = HibernateORM.getInstance();
	private List<House> houseData = new ArrayList<>();
	
	
	public LockSenseBean() {
		
	}
	
	
	@Override
	public void insertHouse(House house) {
		
		Session session = hibernateObject.getSessionFactory().openSession();     
	    Transaction transaction = session.beginTransaction();  

	    session.save(house); 
	    transaction.commit(); 
	    session.close();  
	    
	}
	
	
	@Override
	public House getHouseById(int id) {
        
		Session session = null;
		House house = null;
		
		try {
    	session = hibernateObject.getSessionFactory().openSession();  
	    session.beginTransaction(); 
        
	    house = (House) session.load(House.class, id);
        
		} catch (Exception e) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
		}
        
        return house;
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<House> getAllHouses() {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    
    	session.beginTransaction(); 
        houseData = (List<House>) session.createQuery("FROM House").list();
        
        return houseData;
    }

 
	@Override
    public void updateHouse(House house) {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    session.update(house); 
	    transaction.commit(); 
	    session.close();
    }
	
	
	@Override
	public void deleteHouse(int id) {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 
        House house = (House) session.load(House.class, new Integer(id));
        
	    session.delete(house); 
	    transaction.commit(); 
	    session.close();
        
    }
    
	
	@Override
    @SuppressWarnings({ "rawtypes", "deprecation" })
	public void deleteAllHouses() {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    Query query = session.createQuery("DELETE * FROM sales");
	    query.executeUpdate();
         
	    transaction.commit(); 
	    session.close();
        
    }

}
