package com.lockit.ejb.logic.remote;


import javax.ejb.Remote;
import com.lockit.entity.SenseNotification;


@Remote
public interface SenseNotificationLogicRemote {

	String getSenseNotificationInterval(SenseNotification senseNotification);
	
}
