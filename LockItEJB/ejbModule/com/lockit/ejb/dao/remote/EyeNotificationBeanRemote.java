package com.lockit.ejb.dao.remote;


import java.util.List;
import javax.ejb.Remote;
import com.lockit.entity.EyeNotification;


@Remote
public interface EyeNotificationBeanRemote {

	void insertEyeNotification(EyeNotification eyeNotification);
	EyeNotification getEyeNotificationById(int id);
	List<EyeNotification> getAllEyeNotifications();
	void updateEyeNotification(EyeNotification eyeNotification);
	void deleteEyeNotification(int id);
	void deleteAllEyeNotifications();
}
