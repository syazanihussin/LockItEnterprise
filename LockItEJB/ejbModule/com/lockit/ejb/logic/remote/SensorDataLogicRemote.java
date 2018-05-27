package com.lockit.ejb.logic.remote;
	

import java.util.HashMap;
import javax.ejb.Remote;
import com.lockit.entity.LockSense;
import com.lockit.entity.SensorData;
	

@Remote
public interface SensorDataLogicRemote {

	HashMap<SensorData, LockSense> detectUnusualData();
	
}
