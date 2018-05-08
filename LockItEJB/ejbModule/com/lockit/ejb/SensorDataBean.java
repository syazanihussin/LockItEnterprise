package com.lockit.ejb;


import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lockit.ejb.dao.local.SensorDataBeanLocal;
import com.lockit.ejb.dao.remote.SensorDataBeanRemote;
import com.lockit.entity.SensorData;


@Stateless(mappedName="SensorDataBean")
@LocalBean
public class SensorDataBean implements SensorDataBeanRemote, SensorDataBeanLocal {

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LockItORM");
	EntityManager entityManager = emf.createEntityManager();
	
	
	public SensorDataBean() {
		
	}
	
	
	@Override
	public void insertSensorData(SensorData sensorData) {
		entityManager.getTransaction().begin();
		entityManager.persist(sensorData); 
		entityManager.getTransaction().commit();
	}
	
	
	@Override
	public SensorData getSensorDataById(int id) {
		return (SensorData) entityManager.find(SensorData.class, id);
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<SensorData> getAllSensorDatas() {
		return entityManager.createQuery("From SensorData").getResultList();
    }

 
	@Override
    public void updateSensorData(SensorData sensorData) {
		entityManager.getTransaction().begin();
		entityManager.merge(sensorData); 
		entityManager.getTransaction().commit();
    }
	
	
	@Override
	public void deleteSensorData(int id) {
		SensorData sensorData = (SensorData) entityManager.find(SensorData.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(sensorData); 
		entityManager.getTransaction().commit();
    }
    
	
	@Override
	public void deleteAllSensorDatas() {
		entityManager.getTransaction().begin();
		entityManager.createQuery("DELETE * From SensorData").executeUpdate();
		entityManager.getTransaction().commit();
    }

}
