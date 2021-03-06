package com.lockit.ejb;


import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.lockit.ejb.dao.local.DeviceCodeBeanLocal;
import com.lockit.ejb.dao.remote.DeviceCodeBeanRemote;
import com.lockit.ejb.logic.local.DeviceCodeLogicLocal;
import com.lockit.ejb.logic.remote.DeviceCodeLogicRemote;
import com.lockit.entity.DeviceCode;


@Stateless(mappedName="DeviceCodeBean")
@LocalBean
public class DeviceCodeBean implements DeviceCodeBeanRemote, DeviceCodeBeanLocal, DeviceCodeLogicRemote, DeviceCodeLogicLocal {

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LockItORM");
	EntityManager entityManager = emf.createEntityManager();
	
	
	public DeviceCodeBean() {
		
	}
	
	
	@Override
	public void insertDeviceCode(DeviceCode deviceCode) {
		entityManager.getTransaction().begin();
		entityManager.persist(deviceCode); 
		entityManager.getTransaction().commit();
	}
	
	
	@Override
	public DeviceCode getDeviceCodeByKey(String key) {
		return (DeviceCode) entityManager.find(DeviceCode.class, key);
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<DeviceCode> getAllDeviceCodes() {
		return entityManager.createQuery("From DeviceCode").getResultList();
    }

 
	@Override
    public void updateDeviceCode(DeviceCode deviceCode) {
		entityManager.getTransaction().begin();
		entityManager.merge(deviceCode); 
		entityManager.getTransaction().commit();
    }
	
	
	@Override
	public void deleteDeviceCode(String key) {
		DeviceCode deviceCode = (DeviceCode) entityManager.find(DeviceCode.class, key);
		entityManager.getTransaction().begin();
		entityManager.remove(deviceCode); 
		entityManager.getTransaction().commit();
    }
    
	
	@Override
	public void deleteAllDeviceCodes() {
		entityManager.getTransaction().begin();
		entityManager.createQuery("DELETE * From DeviceCode").executeUpdate();
		entityManager.getTransaction().commit();
    }
	
	
	@Override
	public Boolean verifyDeviceCode(String code) {
		
		Boolean check = false;
		
		for(DeviceCode deviceCode : getAllDeviceCodes()) {
			if(code.equalsIgnoreCase(deviceCode.getKeyz())) {
				check = true;
			}
		}
		
		return check;
    }
	
	
	@Override
	public String determineDeviceType(String code) {
		
		String name = null;
		
		if(verifyDeviceCode(code) == true) {
			DeviceCode deviceCode = getDeviceCodeByKey(code);
			String deviceName = deviceCode.getDeviceInfo_DeviceCode().getDeviceName();
			
			if(deviceName.equalsIgnoreCase("LOCKEYE")) {
				name =  "LOCKEYE";
			} else if (deviceName.equalsIgnoreCase("LOCKSENSE")) {
				name =  "LOCKSENSE";
			}
		}
		
		return name;
    }
	
}
