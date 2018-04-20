package com.lockit.ejb;


import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.lockit.entity.LockEye;


@Stateless(mappedName="LockEyeBean")
@LocalBean
public class LockEyeBean implements LockEyeBeanRemote, LockEyeBeanLocal {

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LockItORM");
	EntityManager entityManager = emf.createEntityManager();
	
	
	public LockEyeBean() {
		
	}
	
	
	@Override
	public void insertLockEye(LockEye lockEye) {
		entityManager.getTransaction().begin();
		entityManager.persist(lockEye); 
		entityManager.getTransaction().commit();
	}
	
	
	@Override
	public LockEye getLockEyeById(int id) {
		return (LockEye) entityManager.find(LockEye.class, id);
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<LockEye> getAllLockEyes() {
		return entityManager.createQuery("From LockEye").getResultList();
    }

 
	@Override
    public void updateLockEye(LockEye lockEye) {
		entityManager.getTransaction().begin();
		entityManager.merge(lockEye); 
		entityManager.getTransaction().commit();
    }
	
	
	@Override
	public void deleteLockEye(int id) {
		LockEye lockEye = (LockEye) entityManager.find(LockEye.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(lockEye); 
		entityManager.getTransaction().commit();
    }
    
	
	@Override
	public void deleteAllLockEyes() {
		entityManager.getTransaction().begin();
		entityManager.createQuery("DELETE * From LockEye").executeUpdate();
		entityManager.getTransaction().commit();
    }

}
