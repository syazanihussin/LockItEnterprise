package com.lockit.ejb.logic.remote;


import javax.ejb.Remote;
import com.lockit.entity.HouseOwner;


@Remote
public interface LockSenseLogicRemote {

	boolean checkLockSenseStatus();
	int calculateTotalLockSense();
}
