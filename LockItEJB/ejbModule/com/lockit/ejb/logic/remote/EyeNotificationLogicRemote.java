package com.lockit.ejb.logic.remote;


import javax.ejb.Remote;
import com.lockit.entity.EyeNotification;


@Remote
public interface EyeNotificationLogicRemote {

	String getEyeNotificationInterval(EyeNotification eyeNotification);
	
}
