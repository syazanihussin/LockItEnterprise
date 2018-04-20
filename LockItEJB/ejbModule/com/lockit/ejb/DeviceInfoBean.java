package com.lockit.ejb;


import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.lockit.entity.DeviceInfo;


@Stateless(mappedName="DeviceInfoBean")
@LocalBean
public class DeviceInfoBean implements DeviceInfoBeanRemote, DeviceInfoBeanLocal {

    
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LockItORM");
	EntityManager entityManager = emf.createEntityManager();
	
	
	public DeviceInfoBean() {
		
	}
	
	
	@Override
	public void insertHouse(DeviceInfo deviceInfo) {
		entityManager.getTransaction().begin();
		entityManager.persist(deviceInfo); 
		entityManager.getTransaction().commit();
	}
	
	
	@Override
	public DeviceInfo getDeviceInfoById(int id) {
		return (DeviceInfo) entityManager.find(DeviceInfo.class, id);
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<DeviceInfo> getAllDeviceInfos() {
		return entityManager.createQuery("From DeviceInfo").getResultList();
    }

 
	@Override
    public void updateDeviceInfo(DeviceInfo deviceInfo) {
		entityManager.getTransaction().begin();
		entityManager.merge(deviceInfo); 
		entityManager.getTransaction().commit();
    }
	
	
	@Override
	public void deleteDeviceInfo(int id) {
		DeviceInfo deviceInfo = (DeviceInfo) entityManager.find(DeviceInfo.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(deviceInfo); 
		entityManager.getTransaction().commit();
    }
    
	
	@Override
	public void deleteAllDeviceInfos() {
		entityManager.getTransaction().begin();
		entityManager.createQuery("DELETE * From DeviceInfo").executeUpdate();
		entityManager.getTransaction().commit();
    }
}
