package com.lockit.ejb.dao;


import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.lockit.entity.DeviceCode;
import com.lockit.util.HibernateORM;


@Stateless
@LocalBean
public class DeviceCodeBean implements DeviceCodeBeanRemote, DeviceCodeBeanLocal {

	HibernateORM hibernateObject = HibernateORM.getInstance();
	private List<DeviceCode> deviceCodeData = new ArrayList<>();
	
	
	public DeviceCodeBean() {
		
	}
	
	
	@Override
	public void insertDeviceCode(DeviceCode deviceCode) {
		
		Session session = hibernateObject.getSessionFactory().openSession();     
	    Transaction transaction = session.beginTransaction();  

	    session.save(deviceCode); 
	    transaction.commit(); 
	    session.close();  
	    
	}
	
	
	@Override
	public DeviceCode getDeviceCodeByKey(String key) {
        
		Session session = null;
		DeviceCode deviceCode = null;
		
		try {
    	session = hibernateObject.getSessionFactory().openSession();  
	    session.beginTransaction(); 
        
	    deviceCode = (DeviceCode) session.load(DeviceCode.class, key);
        
		} catch (Exception e) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
		}
        
        return deviceCode;
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<DeviceCode> getAllDeviceCodes() {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    
    	session.beginTransaction(); 
    	deviceCodeData = (List<DeviceCode>) session.createQuery("FROM devicecode").list();
        
        return deviceCodeData;
    }

 
	@Override
    public void updateDeviceCode(DeviceCode deviceCode) {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    session.update(deviceCode); 
	    transaction.commit(); 
	    session.close();
    }
	
	
	@Override
	public void deleteDeviceCode(String key) {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 
        DeviceCode deviceCode = (DeviceCode) session.load(DeviceCode.class, new String(key));
        
	    session.delete(deviceCode); 
	    transaction.commit(); 
	    session.close();
        
    }
    
	
	@Override
    @SuppressWarnings({ "rawtypes", "deprecation" })
	public void deleteAllDeviceCodes() {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    Query query = session.createQuery("DELETE * FROM devicecode");
	    query.executeUpdate();
         
	    transaction.commit(); 
	    session.close();
        
    }

}
