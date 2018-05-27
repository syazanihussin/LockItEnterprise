package com.lockit.ejb;


import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.lockit.ejb.dao.local.VideoBeanLocal;
import com.lockit.ejb.dao.remote.VideoBeanRemote;
import com.lockit.ejb.logic.local.VideoLogicLocal;
import com.lockit.ejb.logic.remote.VideoLogicRemote;
import com.lockit.entity.Video;


@Stateless(mappedName="VideoBean")
@LocalBean
public class VideoBean implements VideoBeanRemote, VideoBeanLocal, VideoLogicLocal, VideoLogicRemote {

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LockItORM");
	EntityManager entityManager = emf.createEntityManager();
	
	
	public VideoBean() {
		
	}
	
	
	@Override
	public void insertVideo(Video video) {
		entityManager.getTransaction().begin();
		entityManager.persist(video); 
		entityManager.getTransaction().commit();
	}
	
	
	@Override
	public Video getVideoById(int id) {
		return (Video) entityManager.find(Video.class, id);
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<Video> getAllVideos() {
		return entityManager.createQuery("From Video").getResultList();
    }

 
	@Override
    public void updateHouse(Video video) {
		entityManager.getTransaction().begin();
		entityManager.merge(video); 
		entityManager.getTransaction().commit();
    }
	
	
	@Override
	public void deleteVideo(int id) {
		Video video = (Video) entityManager.find(Video.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(video); 
		entityManager.getTransaction().commit();
    }
    
	
	@Override
	public void deleteAllVideos() {
		entityManager.getTransaction().begin();
		entityManager.createQuery("DELETE * From Video").executeUpdate();
		entityManager.getTransaction().commit();
    }
	
	
	@Override
	public double calculateRemainingSpace() {
		
		double total = 0 ;
		
		for(Video video : getAllVideos()) {
			total += video.getVideoSize();
		}
		
		return (double) 50 - total ;
	}
	
	
	@Override
	public int calculateTotalVideo() {
		return getAllVideos().size();
	}

}
