package com.lockit.ejb.logic.remote;


import javax.ejb.Remote;


@Remote
public interface NotificationLogicRemote {

	int calculateTotalNotifications();
	String classifyInterval(long interval);
	
}
