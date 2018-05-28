package com.lockit.ejb.logic.remote;


import java.util.HashMap;
import javax.ejb.Remote;
import com.lockit.entity.LockSense;
import com.lockit.entity.SensorData;


@Remote
public interface LockSenseLogicRemote {

	HashMap<SensorData, LockSense> checkLockSenseStatus(int id);
	int calculateTotalLockSense();
}
