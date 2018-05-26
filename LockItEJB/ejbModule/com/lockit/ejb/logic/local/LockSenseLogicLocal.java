package com.lockit.ejb.logic.local;


import javax.ejb.Local;
import com.lockit.entity.HouseOwner;


@Local
public interface LockSenseLogicLocal {

	boolean checkLockSenseStatus();
	int calculateTotalLockSense();
}
