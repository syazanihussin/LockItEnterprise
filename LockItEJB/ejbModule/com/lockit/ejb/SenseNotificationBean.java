package com.lockit.ejb;


import java.sql.Timestamp;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.lockit.ejb.dao.local.SenseNotificationBeanLocal;
import com.lockit.ejb.dao.remote.SenseNotificationBeanRemote;
import com.lockit.ejb.logic.local.NotificationLogicLocal;
import com.lockit.ejb.logic.local.SenseNotificationLogicLocal;
import com.lockit.ejb.logic.remote.SenseNotificationLogicRemote;
import com.lockit.entity.SenseNotification;


@Stateless(mappedName="SenseNotificationBean")
@LocalBean
public class SenseNotificationBean implements SenseNotificationBeanRemote, SenseNotificationBeanLocal,
		SenseNotificationLogicRemote, SenseNotificationLogicLocal{

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LockItORM");
	EntityManager entityManager = emf.createEntityManager();
	NotificationLogicLocal notificationBean = new NotificationBean();
	
	
	public SenseNotificationBean() {
		
	}
	
	
	@Override
	public void insertSenseNotification(SenseNotification senseNotification) {
		entityManager.getTransaction().begin();
		entityManager.persist(senseNotification); 
		entityManager.getTransaction().commit();
	}
	
	
	@Override
	public SenseNotification getSenseNotificationById(int id) {
		return (SenseNotification) entityManager.find(SenseNotification.class, id);
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<SenseNotification> getAllSenseNotifications() {
		return entityManager.createQuery("From SenseNotification").getResultList();
    }

 
	@Override
    public void updateSenseNotification(SenseNotification senseNotification) {
		entityManager.getTransaction().begin();
		entityManager.merge(senseNotification); 
		entityManager.getTransaction().commit();
    }
	
	
	@Override
	public void deleteSenseNotification(int id) {
		SenseNotification senseNotification = (SenseNotification) entityManager.find(SenseNotification.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(senseNotification); 
		entityManager.getTransaction().commit();
    }
    
	
	@Override
	public void deleteAllSenseNotifications() {
		entityManager.getTransaction().begin();
		entityManager.createQuery("DELETE * From SenseNotification").executeUpdate();
		entityManager.getTransaction().commit();
    }
	
	
	@Override
	public String getSenseNotificationInterval(SenseNotification senseNotification) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		long interval = timestamp.getTime() - (long) senseNotification.getSenseTimestamp();
		return notificationBean.classifyNotificationUnit(interval);
	}
	

}
