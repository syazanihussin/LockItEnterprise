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
	VideoBeanLocal videoBeanLocal = null;
	
	
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
	public HashMap<Video, LockEye> checkLockEyeStatus() {

		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");  
	    Date date = new Date(); 
		String df = formatter.format(date);  
	    long currentTimestamp = Long.parseLong(df);
	    
	    HashMap<Video, LockEye> map = new HashMap<Video, LockEye>();
		List<LockEye> lockEyeList = getAllLockEyes();
		
		
		for(LockEye lockEye: lockEyeList) {
			
			List<Video> videoList = lockEye.getVideo();
			int lastIndex = videoList.size() - 1;
			
			Video video = videoList.get(lastIndex);
			
			if(currentTimestamp - video.getEndRecordingTime() > 2000) {
				map.put(video, lockEye);
			}	
		}
		return map;
	}
	
	
	@Override
	public int calculateTotalLockEye() {
		return getAllLockEyes().size();
	}
}
