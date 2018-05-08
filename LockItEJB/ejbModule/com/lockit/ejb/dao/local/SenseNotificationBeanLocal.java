package com.lockit.ejb.dao.local;


import java.util.List;
import javax.ejb.Local;
import com.lockit.entity.SenseNotification;


@Local
public interface SenseNotificationBeanLocal {

	void insertSenseNotification(SenseNotification senseNotification);
	SenseNotification getSenseNotificationById(int id);
	List<SenseNotification> getAllSenseNotifications();
	void updateSenseNotification(SenseNotification senseNotification);
	void deleteSenseNotification(int id);
	void deleteAllSenseNotifications();

}
