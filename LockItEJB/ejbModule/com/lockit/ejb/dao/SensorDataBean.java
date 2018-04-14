package com.lockit.ejb.dao;


import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.lockit.entity.SensorData;
import com.lockit.util.HibernateORM;


@Stateless
@LocalBean
public class SensorDataBean implements SensorDataBeanRemote, SensorDataBeanLocal {

	HibernateORM hibernateObject = HibernateORM.getInstance();
	private List<SensorData> sensorDataData = new ArrayList<>();
	
	
	public SensorDataBean() {
		
	}
	
	
	@Override
	public void insertSensorData(SensorData sensorData) {
		
		Session session = hibernateObject.getSessionFactory().openSession();     
	    Transaction transaction = session.beginTransaction();  

	    session.save(sensorData); 
	    transaction.commit(); 
	    session.close();  
	    
	}
	
	
	@Override
	public SensorData getSensorDataById(int id) {
        
		Session session = null;
		SensorData sensorData = null;
		
		try {
    	session = hibernateObject.getSessionFactory().openSession();  
	    session.beginTransaction(); 
        
	    sensorData = (SensorData) session.load(SensorData.class, id);
        
		} catch (Exception e) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
		}
        
        return sensorData;
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<SensorData> getAllSensorDatas() {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    
    	session.beginTransaction(); 
    	sensorDataData = (List<SensorData>) session.createQuery("FROM sensordata").list();
        
        return sensorDataData;
    }

 
	@Override
    public void updateSensorData(SensorData sensorData) {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    session.update(sensorData); 
	    transaction.commit(); 
	    session.close();
    }
	
	
	@Override
	public void deleteSensorData(int id) {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 
	    SensorData sensorData = (SensorData) session.load(SensorData.class, new Integer(id));
        
	    session.delete(sensorData); 
	    transaction.commit(); 
	    session.close();
        
    }
    
	
	@Override
    @SuppressWarnings({ "rawtypes", "deprecation" })
	public void deleteAllSensorDatas() {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    Query query = session.createQuery("DELETE * FROM sensordata");
	    query.executeUpdate();
         
	    transaction.commit(); 
	    session.close();
        
    }

}
