package com.lockit.ejb.logic.local;


import javax.ejb.Local;


@Local
public interface NotificationLogicLocal {
	
	int calculateTotalNotifications();
	String classifyInterval(long interval);

}
