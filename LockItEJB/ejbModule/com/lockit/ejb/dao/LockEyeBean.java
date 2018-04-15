package com.lockit.ejb.dao;


import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.lockit.entity.LockEye;
import com.lockit.util.HibernateORM;


@Stateless
@LocalBean
public class LockEyeBean implements LockEyeBeanRemote, LockEyeBeanLocal {

	HibernateORM hibernateObject = HibernateORM.getInstance();
	private List<LockEye> lockEyeData = new ArrayList<>();
	
	
	public LockEyeBean() {
		
	}
	
	
	@Override
	public void insertLockEye(LockEye lockEye) {
		
		Session session = hibernateObject.getSessionFactory().openSession();     
	    Transaction transaction = session.beginTransaction();  

	    session.save(lockEye); 
	    transaction.commit(); 
	    session.close();  
	    
	}
	
	
	@Override
	public LockEye getLockEyeById(int id) {
        
		Session session = null;
		LockEye lockEye = null;
		
		try {
    	session = hibernateObject.getSessionFactory().openSession();  
	    session.beginTransaction(); 
        
	    lockEye = (LockEye) session.load(LockEye.class, id);
        
		} catch (Exception e) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
		}
        
        return lockEye;
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<LockEye> getAllLockEyes() {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    
    	session.beginTransaction(); 
    	lockEyeData = (List<LockEye>) session.createQuery("FROM lockeye").list();
        
        return lockEyeData;
    }

 
	@Override
    public void updateLockEye(LockEye lockEye) {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    session.update(lockEye); 
	    transaction.commit(); 
	    session.close();
    }
	
	
	@Override
	public void deleteLockEye(int id) {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 
	    LockEye lockEye = (LockEye) session.load(LockEye.class, new Integer(id));
        
	    session.delete(lockEye); 
	    transaction.commit(); 
	    session.close();
        
    }
    
	
	@Override
    @SuppressWarnings({ "rawtypes", "deprecation" })
	public void deleteAllLockEyes() {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    Query query = session.createQuery("DELETE * FROM lockeye");
	    query.executeUpdate();
         
	    transaction.commit(); 
	    session.close();
        
    }

}
