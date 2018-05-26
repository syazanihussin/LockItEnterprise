package com.lockit.ejb.dao.local;


import java.util.List;
import javax.ejb.Local;

import com.lockit.entity.LockEye;
import com.lockit.entity.Video;


@Local
public interface VideoBeanLocal {

	void insertVideo(Video video);
	Video getVideoById(int id);
	List<Video> getAllVideos();
	void updateHouse(Video video);
	void deleteVideo(int id);
	void deleteAllVideos();
	List<LockEye> getAllLockEyes();

}
