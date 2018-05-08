package com.lockit.ejb;


import java.sql.Timestamp;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.lockit.ejb.dao.local.EyeNotificationBeanLocal;
import com.lockit.ejb.dao.remote.EyeNotificationBeanRemote;
import com.lockit.ejb.logic.local.EyeNotificationLogicLocal;
import com.lockit.ejb.logic.local.NotificationLogicLocal;
import com.lockit.ejb.logic.remote.EyeNotificationLogicRemote;
import com.lockit.entity.EyeNotification;


@Stateless(mappedName="EyeNotificationBean")
@LocalBean
public class EyeNotificationBean implements EyeNotificationBeanRemote, EyeNotificationBeanLocal, 
		EyeNotificationLogicRemote, EyeNotificationLogicLocal {

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LockItORM");
	EntityManager entityManager = emf.createEntityManager();
	NotificationLogicLocal notificationBean = new NotificationBean();
	
	
	public EyeNotificationBean() {
		
	}
	
	
	@Override
	public void insertEyeNotification(EyeNotification eyeNotification) {
		entityManager.getTransaction().begin();
		entityManager.persist(eyeNotification); 
		entityManager.getTransaction().commit();
	}
	
	
	@Override
	public EyeNotification getEyeNotificationById(int id) {
		return (EyeNotification) entityManager.find(EyeNotification.class, id);
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<EyeNotification> getAllEyeNotifications() {
		return entityManager.createQuery("From EyeNotification").getResultList();
    }

 
	@Override
    public void updateEyeNotification(EyeNotification eyeNotification) {
		entityManager.getTransaction().begin();
		entityManager.merge(eyeNotification); 
		entityManager.getTransaction().commit();
    }
	
	
	@Override
	public void deleteEyeNotification(int id) {
		EyeNotification eyeNotification = (EyeNotification) entityManager.find(EyeNotification.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(eyeNotification); 
		entityManager.getTransaction().commit();
    }
    
	
	@Override
	public void deleteAllEyeNotifications() {
		entityManager.getTransaction().begin();
		entityManager.createQuery("DELETE * From EyeNotification").executeUpdate();
		entityManager.getTransaction().commit();
    }
	
	
	@Override
	public String getEyeNotificationInterval(EyeNotification eyeNotification) {
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		long interval = timestamp.getTime() - (long) eyeNotification.getEyeTimestamp();
		
		return notificationBean.classifyInterval(interval);
	}

}
