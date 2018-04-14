package com.lockit.ejb.dao;


import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.lockit.entity.DeviceInfo;
import com.lockit.util.HibernateORM;


@Stateless
@LocalBean
public class DeviceInfoBean implements DeviceInfoBeanRemote, DeviceInfoBeanLocal {

    
	HibernateORM hibernateObject = HibernateORM.getInstance();
	private List<DeviceInfo> deviceInfoData = new ArrayList<>();
	
	
	public DeviceInfoBean() {
		
	}
	
	
	@Override
	public void insertHouse(DeviceInfo deviceInfo) {
		
		Session session = hibernateObject.getSessionFactory().openSession();     
	    Transaction transaction = session.beginTransaction();  

	    session.save(deviceInfo); 
	    transaction.commit(); 
	    session.close();  
	    
	}
	
	
	@Override
	public DeviceInfo getDeviceInfoById(int id) {
        
		Session session = null;
		DeviceInfo deviceInfo = null;
		
		try {
    	session = hibernateObject.getSessionFactory().openSession();  
	    session.beginTransaction(); 
        
	    deviceInfo = (DeviceInfo) session.load(DeviceInfo.class, id);
        
		} catch (Exception e) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
		}
        
        return deviceInfo;
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<DeviceInfo> getAllDeviceInfos() {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    
    	session.beginTransaction(); 
    	deviceInfoData = (List<DeviceInfo>) session.createQuery("FROM deviceinfo").list();
        
        return deviceInfoData;
    }

 
	@Override
    public void updateDeviceInfo(DeviceInfo deviceInfo) {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    session.update(deviceInfo); 
	    transaction.commit(); 
	    session.close();
    }
	
	
	@Override
	public void deleteDeviceInfo(int id) {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 
	    DeviceInfo deviceInfo = (DeviceInfo) session.load(DeviceInfo.class, new Integer(id));
        
	    session.delete(deviceInfo); 
	    transaction.commit(); 
	    session.close();
        
    }
    
	
	@Override
    @SuppressWarnings({ "rawtypes", "deprecation" })
	public void deleteAllDeviceInfos() {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    Query query = session.createQuery("DELETE * FROM deviceinfo");
	    query.executeUpdate();
         
	    transaction.commit(); 
	    session.close();
        
    }
}
