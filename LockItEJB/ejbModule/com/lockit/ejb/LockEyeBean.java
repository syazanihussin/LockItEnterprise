package com.lockit.ejb;


import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lockit.ejb.dao.local.LockEyeBeanLocal;
import com.lockit.ejb.dao.local.VideoBeanLocal;
import com.lockit.ejb.dao.remote.LockEyeBeanRemote;
import com.lockit.ejb.logic.local.LockEyeLogicLocal;
import com.lockit.ejb.logic.remote.LockEyeLogicRemote;
import com.lockit.entity.LockEye;
import com.lockit.entity.Video;



@Stateless(mappedName="LockEyeBean")
@LocalBean
public class LockEyeBean implements LockEyeBeanRemote, LockEyeBeanLocal, LockEyeLogicRemote, LockEyeLogicLocal {

	
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

	
	@Override
	public Boolean checkLockEyeStatus() {

	
	 
	 List<LockEye> a= getAllLockEyes();
	 
		for(LockEye LE: a) {
		
			int last = LE.getVideo().size()-1;
			
			 VideoBeanLocal b=new VideoBean();
			 Video v=b.getVideoById(last);
			 
			 if(v.getVideoClip()>  2000) {
				 return true;
			 }
				 else {
					 return false;
				 }
		 }
	}
	}
		
	
	@Override
	public int calculateTotalLockEye() {
		return getAllLockEyes().size();
	}
}
