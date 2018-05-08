package com.lockit.ejb.logic.local;


import javax.ejb.Local;
import com.lockit.entity.EyeNotification;


@Local
public interface EyeNotificationLogicLocal {
	
	String getEyeNotificationInterval(EyeNotification eyeNotification);

}
