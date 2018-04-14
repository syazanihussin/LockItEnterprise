package com.lockit.ejb.dao;


import java.util.List;
import javax.ejb.Remote;
import com.lockit.entity.Video;


@Remote
public interface VideoBeanRemote {
	
	void insertVideo(Video video);
	Video getVideoById(int id);
	List<Video> getAllVideos();
	void updateHouse(Video video);
	void deleteVideo(int id);
	void deleteAllVideos();

}
