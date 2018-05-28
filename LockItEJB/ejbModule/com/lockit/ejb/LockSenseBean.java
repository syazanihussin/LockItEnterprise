package com.lockit.ejb;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.lockit.ejb.dao.local.LockSenseBeanLocal;
import com.lockit.ejb.dao.remote.LockSenseBeanRemote;
import com.lockit.ejb.logic.local.LockSenseLogicLocal;
import com.lockit.ejb.logic.remote.LockSenseLogicRemote;
import com.lockit.entity.LockSense;
import com.lockit.entity.SensorData;


@Stateless(mappedName="LockSenseBean")
@LocalBean
public class LockSenseBean implements LockSenseBeanRemote, LockSenseBeanLocal, LockSenseLogicLocal, LockSenseLogicRemote {

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LockItORM");
	EntityManager entityManager = emf.createEntityManager();
	
	
	public LockSenseBean() {
		
	}
	
	
	@Override
	public int insertLockSense(LockSense lockSense) {
		entityManager.getTransaction().begin();
		entityManager.persist(lockSense); 
		entityManager.getTransaction().commit();
		return lockSense.getLocksenseID();
	}
	
	
	@Override
	public LockSense getLockSenseById(int id) {
		return (LockSense) entityManager.find(LockSense.class, id);
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<LockSense> getAllLockSenses() {
		return entityManager.createQuery("From LockSense").getResultList();
    }

 
	@Override
    public void updateLockSense(LockSense lockSense) {
		entityManager.getTransaction().begin();
		entityManager.merge(lockSense); 
		entityManager.getTransaction().commit();
    }
	
	
	@Override
	public void deleteLockSense(int id) {
		LockSense lockSense = (LockSense) entityManager.find(LockSense.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(lockSense); 
		entityManager.getTransaction().commit();
    }
    
	
	@Override
	public void deleteAllLockSenses() {
		entityManager.getTransaction().begin();
		entityManager.createQuery("DELETE * From LockSense").executeUpdate();
		entityManager.getTransaction().commit();
    }
	
	
	@Override
	public HashMap<SensorData, LockSense> checkLockSenseStatus(int id) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");  
	    Date date = new Date(); 
		String df = formatter.format(date);  
	    long currentTimestamp = Long.parseLong(df);
	    
	    HashMap<SensorData, LockSense> map = new HashMap<SensorData, LockSense>();
		LockSense lockSense = getLockSenseById(id);
		
		List<SensorData> sensorDataList = lockSense.getSensorData();
		int lastIndex = sensorDataList.size() - 1;
			
		SensorData sensorData = sensorDataList.get(lastIndex);
			
		if(currentTimestamp - sensorData.getDataTimestamp() > Long.parseLong("900000")) {
			map.put(sensorData, lockSense);
		}	
	
		return map;
	}
	
	@Override
	public int calculateTotalLockSense() {		
		return getAllLockSenses().size();		
	}

}
