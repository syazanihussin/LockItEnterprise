package com.lockit.ejb.logic.local;


import javax.ejb.Local;
import com.lockit.entity.SenseNotification;


@Local
public interface SenseNotificationLogicLocal {
	
	String getSenseNotificationInterval(SenseNotification senseNotification);

}
