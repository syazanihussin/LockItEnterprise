package com.lockit.ejb.dao;


import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.lockit.entity.LockSense;
import com.lockit.util.HibernateORM;


@Stateless
@LocalBean
public class LockSenseBean implements LockSenseBeanRemote, LockSenseBeanLocal {

	HibernateORM hibernateObject = HibernateORM.getInstance();
	private List<LockSense> lockSenseData = new ArrayList<>();
	
	
	public LockSenseBean() {
		
	}
	
	
	@Override
	public void insertLockSense(LockSense lockSense) {
		
		Session session = hibernateObject.getSessionFactory().openSession();     
	    Transaction transaction = session.beginTransaction();  

	    session.save(lockSense); 
	    transaction.commit(); 
	    session.close();  
	    
	}
	
	
	@Override
	public LockSense getLockSenseById(int id) {
        
		Session session = null;
		LockSense lockSense = null;
		
		try {
    	session = hibernateObject.getSessionFactory().openSession();  
	    session.beginTransaction(); 
        
	    lockSense = (LockSense) session.load(LockSense.class, id);
        
		} catch (Exception e) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
		}
        
        return lockSense;
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<LockSense> getAllLockSenses() {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    
    	session.beginTransaction(); 
    	lockSenseData = (List<LockSense>) session.createQuery("FROM locksense").list();
        
        return lockSenseData;
    }

 
	@Override
    public void updateLockSense(LockSense lockSense) {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    session.update(lockSense); 
	    transaction.commit(); 
	    session.close();
    }
	
	
	@Override
	public void deleteLockSense(int id) {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 
	    LockSense lockSense = (LockSense) session.load(LockSense.class, new Integer(id));
        
	    session.delete(lockSense); 
	    transaction.commit(); 
	    session.close();
        
    }
    
	
	@Override
    @SuppressWarnings({ "rawtypes", "deprecation" })
	public void deleteAllLockSenses() {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    Query query = session.createQuery("DELETE * FROM locksense");
	    query.executeUpdate();
         
	    transaction.commit(); 
	    session.close();
        
    }

}
