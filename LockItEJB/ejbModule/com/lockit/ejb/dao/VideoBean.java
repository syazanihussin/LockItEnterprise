package com.lockit.ejb.dao;


import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.lockit.entity.Video;
import com.lockit.util.HibernateORM;


@Stateless
@LocalBean
public class VideoBean implements VideoBeanRemote, VideoBeanLocal {

	HibernateORM hibernateObject = HibernateORM.getInstance();
	private List<Video> videoData = new ArrayList<>();
	
	
	public VideoBean() {
		
	}
	
	
	@Override
	public void insertVideo(Video video) {
		
		Session session = hibernateObject.getSessionFactory().openSession();     
	    Transaction transaction = session.beginTransaction();  

	    session.save(video); 
	    transaction.commit(); 
	    session.close();  
	    
	}
	
	
	@Override
	public Video getVideoById(int id) {
        
		Session session = null;
		Video video = null;
		
		try {
    	session = hibernateObject.getSessionFactory().openSession();  
	    session.beginTransaction(); 
        
	    video = (Video) session.load(Video.class, id);
        
		} catch (Exception e) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
		}
        
        return video;
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<Video> getAllVideos() {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    
    	session.beginTransaction(); 
    	videoData = (List<Video>) session.createQuery("FROM video").list();
        
        return videoData;
    }

 
	@Override
    public void updateHouse(Video video) {
        
    	Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    session.update(video); 
	    transaction.commit(); 
	    session.close();
    }
	
	
	@Override
	public void deleteVideo(int id) {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 
	    Video house = (Video) session.load(Video.class, new Integer(id));
        
	    session.delete(house); 
	    transaction.commit(); 
	    session.close();
        
    }
    
	
	@Override
    @SuppressWarnings({ "rawtypes", "deprecation" })
	public void deleteAllVideos() {
		
		Session session = hibernateObject.getSessionFactory().openSession();  
	    Transaction transaction = session.beginTransaction(); 

	    Query query = session.createQuery("DELETE * FROM video");
	    query.executeUpdate();
         
	    transaction.commit(); 
	    session.close();
        
    }

}
