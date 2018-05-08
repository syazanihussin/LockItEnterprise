package com.lockit.ejb.dao.local;


import java.util.List;
import javax.ejb.Local;
import com.lockit.entity.EyeNotification;


@Local
public interface EyeNotificationBeanLocal {

	void insertEyeNotification(EyeNotification eyeNotification);
	EyeNotification getEyeNotificationById(int id);
	List<EyeNotification> getAllEyeNotifications();
	void updateEyeNotification(EyeNotification eyeNotification);
	void deleteEyeNotification(int id);
	void deleteAllEyeNotifications();

}
