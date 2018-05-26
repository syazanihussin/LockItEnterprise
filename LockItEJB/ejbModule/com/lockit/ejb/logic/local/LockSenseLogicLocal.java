package com.lockit.ejb.logic.local;


import java.util.HashMap;
import javax.ejb.Local;
import com.lockit.entity.LockSense;
import com.lockit.entity.SensorData;


@Local
public interface LockSenseLogicLocal {

	HashMap<LockSense, SensorData> checkLockSenseStatus();
	int calculateTotalLockSense();
}
