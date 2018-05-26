package com.lockit.ejb.logic.remote;


import javax.ejb.Remote;



@Remote
public interface LockEyeLogicRemote {

	Boolean checkLockEyeStatus();

	int calculateTotalLockEye();
	
}
