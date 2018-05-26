package com.lockit.ejb.logic.local;


import javax.ejb.Local;



@Local
public interface LockEyeLogicLocal {

	Boolean checkLockEyeStatus();

	int calculateTotalLockEye();
	
	

}
