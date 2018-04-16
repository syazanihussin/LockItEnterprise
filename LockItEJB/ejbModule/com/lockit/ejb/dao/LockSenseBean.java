package com.lockit.ejb.dao;


import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.lockit.entity.LockSense;


@Stateless(mappedName="LockSenseBean")
@LocalBean
public class LockSenseBean implements LockSenseBeanRemote, LockSenseBeanLocal {

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LockItORM");
	EntityManager entityManager = emf.createEntityManager();
	
	
	public LockSenseBean() {
		
	}
	
	
	@Override
	public void insertLockSense(LockSense lockSense) {
		entityManager.getTransaction().begin();
		entityManager.persist(lockSense); 
		entityManager.getTransaction().commit();
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

}
