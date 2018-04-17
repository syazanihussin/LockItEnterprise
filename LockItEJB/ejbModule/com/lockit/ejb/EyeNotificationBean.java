package com.lockit.ejb;


import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.lockit.entity.EyeNotification;


@Stateless(mappedName="EyeNotificationBean")
@LocalBean
public class EyeNotificationBean implements EyeNotificationBeanRemote, EyeNotificationBeanLocal {

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LockItORM");
	EntityManager entityManager = emf.createEntityManager();
	
	
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

}
