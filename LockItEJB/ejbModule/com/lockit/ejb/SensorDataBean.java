package com.lockit.ejb;


import java.util.HashMap;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.lockit.ejb.dao.local.LockSenseBeanLocal;
import com.lockit.ejb.dao.local.SensorDataBeanLocal;
import com.lockit.ejb.dao.remote.SensorDataBeanRemote;
import com.lockit.ejb.logic.local.SensorDataLogicLocal;
import com.lockit.ejb.logic.remote.SensorDataLogicRemote;
import com.lockit.entity.LockSense;
import com.lockit.entity.SensorData;


@Stateless(mappedName="SensorDataBean")
@LocalBean
public class SensorDataBean implements SensorDataBeanRemote, SensorDataBeanLocal,SensorDataLogicLocal, SensorDataLogicRemote {
	
	
	//factory	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LockItORM");
	EntityManager entityManager = emf.createEntityManager();
	LockSenseBeanLocal lockSenseBeanLocal = null;
	
	
	//empty
	public SensorDataBean() {
		super();
	}
	
	
	///CRUD FUNCTION
	//insert data process
	@Override
	public void insertSensorData(SensorData sensorData) {
		entityManager.getTransaction().begin();
		entityManager.persist(sensorData); 
		entityManager.getTransaction().commit();
	}
	
	
	//return data
	@Override
	public SensorData getSensorDataById(int id) {
		return (SensorData) entityManager.find(SensorData.class, id);
    }

    
	//get all data
	@Override
	@SuppressWarnings("unchecked")
	public List<SensorData> getAllSensorDatas() {
		return entityManager.createQuery("From SensorData").getResultList();
    }

  
	//update data
	@Override
    public void updateSensorData(SensorData sensorData) {
		entityManager.getTransaction().begin();
		entityManager.merge(sensorData); 
		entityManager.getTransaction().commit();
    }
	
	
	//delete selected data
	@Override
	public void deleteSensorData(int id) {
		SensorData sensorData = (SensorData) entityManager.find(SensorData.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(sensorData); 
		entityManager.getTransaction().commit();
    }
    
	
	//delete all data
	@Override
	public void deleteAllSensorDatas() {
		entityManager.getTransaction().begin();
		entityManager.createQuery("DELETE * From SensorData").executeUpdate();
		entityManager.getTransaction().commit();
    }
	
	
	//detection of data unusual
	@Override
	public HashMap<SensorData, LockSense> detectUnusualData() {	
		
		lockSenseBeanLocal = new LockSenseBean();
		HashMap<SensorData, LockSense> map = new HashMap<SensorData, LockSense>();
		
		for(LockSense lockSense : lockSenseBeanLocal.getAllLockSenses()) {
			for(SensorData sensorData : lockSense.getSensorData()) {
				
				if(sensorData.getData()>2000) {
					map.put(sensorData, lockSense); ;	
				}		
			}
		}
		return map;	
	}
		
}
	
	
	
	



