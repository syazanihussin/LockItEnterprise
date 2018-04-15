package com.lockit.ejb.dao;


import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.lockit.entity.SenseNotification;
import com.lockit.util.HibernateORM;


@Stateless
@LocalBean
public class SenseNotificationBean implements SenseNotificationBeanRemote, SenseNotificationBeanLocal {

	HibernateORM hibernateObject = HibernateORM.getInstance();
	private List<SenseNotification> senseNotificationData = new ArrayList<>();
	
	
	public SenseNotificationBean() {
		
	}
	
	
	@Override
	public void insertSenseNotification(SenseNotification senseNotification) {
		
		Session session = hibernateObject.getSessionFactory().openSession();     
	    Transaction transaction = session.beginTransaction();  

	    session.save(senseNotification); 
	    transaction.commit(); 
	    session.close();  
	    
	}
	
	
	@Override
	public SenseNotification getSenseNotificationById(int id) {
        
		Session session = null;
		SenseNotification senseNotification = null;
		
		try {
    	session = hibernateObject.getSessionFactory().openSession();  
	    session.beginTransaction(); 
        
	    senseNotification = (SenseNotification) session.load(SenseNotification.class, id);
        
		} catch (Exception e) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
		}
        
        return senseNotification;
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<SenseNotification> getAllSenseNotifications() {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    
    	session.beginTransaction(); 
    	senseNotificationData = (List<SenseNotification>) session.createQuery("FROM sensenotification").list();
        
        return senseNotificationData;
    }

 
	@Override
    public void updateSenseNotification(SenseNotification senseNotification) {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    session.update(senseNotification); 
	    transaction.commit(); 
	    session.close();
    }
	
	
	@Override
	public void deleteSenseNotification(int id) {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 
	    SenseNotification senseNotification = (SenseNotification) session.load(SenseNotification.class, new Integer(id));
        
	    session.delete(senseNotification); 
	    transaction.commit(); 
	    session.close();
        
    }
    
	
	@Override
    @SuppressWarnings({ "rawtypes", "deprecation" })
	public void deleteAllSenseNotifications() {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    Query query = session.createQuery("DELETE * FROM sensenotification");
	    query.executeUpdate();
         
	    transaction.commit(); 
	    session.close();
        
    }

}
