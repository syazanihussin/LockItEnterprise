package com.lockit.ejb.dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.lockit.entity.EyeNotification;
import com.lockit.util.HibernateORM;


@Stateless
@LocalBean
public class EyeNotificationBean implements EyeNotificationBeanRemote, EyeNotificationBeanLocal {

	HibernateORM hibernateObject = HibernateORM.getInstance();
	private List<EyeNotification> eyeNotificationData = new ArrayList<>();
	
	
	public EyeNotificationBean() {
		
	}
	
	
	@Override
	public void insertEyeNotification(EyeNotification eyeNotification) {
		
		Session session = hibernateObject.getSessionFactory().openSession();     
	    Transaction transaction = session.beginTransaction();  

	    session.save(eyeNotification); 
	    transaction.commit(); 
	    session.close();  
	    
	}
	
	
	@Override
	public EyeNotification getEyeNotificationById(int id) {
        
		Session session = null;
		EyeNotification eyeNotification = null;
		
		try {
    	session = hibernateObject.getSessionFactory().openSession();  
	    session.beginTransaction(); 
        
	    eyeNotification = (EyeNotification) session.load(EyeNotification.class, id);
        
		} catch (Exception e) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
		}
        
        return eyeNotification;
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<EyeNotification> getAllEyeNotifications() {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    
    	session.beginTransaction(); 
    	eyeNotificationData = (List<EyeNotification>) session.createQuery("FROM eyenotification").list();
        
        return eyeNotificationData;
    }

 
	@Override
    public void updateEyeNotification(EyeNotification eyeNotification) {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    session.update(eyeNotification); 
	    transaction.commit(); 
	    session.close();
    }
	
	
	@Override
	public void deleteEyeNotification(int id) {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 
	    EyeNotification eyeNotification = (EyeNotification) session.load(EyeNotification.class, new Integer(id));
        
	    session.delete(eyeNotification); 
	    transaction.commit(); 
	    session.close();
        
    }
    
	
	@Override
    @SuppressWarnings({ "rawtypes", "deprecation" })
	public void deleteAllEyeNotifications() {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    Query query = session.createQuery("DELETE * FROM eyenotification");
	    query.executeUpdate();
         
	    transaction.commit(); 
	    session.close();
        
    }

}
