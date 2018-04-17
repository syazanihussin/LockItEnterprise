package com.lockit.ejb;


import java.util.List;
import javax.ejb.Remote;
import com.lockit.entity.SenseNotification;


@Remote
public interface SenseNotificationBeanRemote {
	
	void insertSenseNotification(SenseNotification senseNotification);
	SenseNotification getSenseNotificationById(int id);
	List<SenseNotification> getAllSenseNotifications();
	void updateSenseNotification(SenseNotification senseNotification);
	void deleteSenseNotification(int id);
	void deleteAllSenseNotifications();

}
