package com.lockit.ejb.dao;


import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.lockit.entity.HouseOwner;
import com.lockit.util.HibernateORM;


@Stateless
@LocalBean
public class HouseOwnerBean implements HouseOwnerBeanRemote, HouseOwnerBeanLocal {

    
	HibernateORM hibernateObject = HibernateORM.getInstance();
	private List<HouseOwner> houseOwnerData = new ArrayList<>();
	
	
	public HouseOwnerBean() {
		
	}
	
	
	@Override
	public void insertHouseOwner(HouseOwner houseOwner) {
		
		Session session = hibernateObject.getSessionFactory().openSession();     
	    Transaction transaction = session.beginTransaction();  

	    session.save(houseOwner); 
	    transaction.commit(); 
	    session.close();  
	    
	}
	
	
	@Override
	public HouseOwner getHouseOwnerById(int id) {
        
		Session session = null;
		HouseOwner houseOwner = null;
		
		try {
    	session = hibernateObject.getSessionFactory().openSession();  
	    session.beginTransaction(); 
        
	    houseOwner = (HouseOwner) session.load(HouseOwner.class, id);
        
		} catch (Exception e) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
		}
        
        return houseOwner;
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<HouseOwner> getAllHouseOwners() {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    
    	session.beginTransaction(); 
    	houseOwnerData = (List<HouseOwner>) session.createQuery("FROM houseowner").list();
        
        return houseOwnerData;
    }

 
	@Override
    public void updateHouseOwner(HouseOwner houseOwner) {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    session.update(houseOwner); 
	    transaction.commit(); 
	    session.close();
    }
	
	
	@Override
	public void deleteHouseOwner(int id) {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 
	    HouseOwner houseOwner = (HouseOwner) session.load(HouseOwner.class, new Integer(id));
        
	    session.delete(houseOwner); 
	    transaction.commit(); 
	    session.close();
        
    }
    
	
	@Override
    @SuppressWarnings({ "rawtypes", "deprecation" })
	public void deleteAllHouseOwners() {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    Query query = session.createQuery("DELETE * FROM houseowner");
	    query.executeUpdate();
         
	    transaction.commit(); 
	    session.close();
        
    }
}
