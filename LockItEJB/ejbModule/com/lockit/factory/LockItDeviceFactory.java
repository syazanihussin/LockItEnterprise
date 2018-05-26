package com.lockit.factory;


import com.lockit.entity.LockEye;
import com.lockit.entity.LockSense;
import com.lockit.interfaces.LockItDevice;


public class LockItDeviceFactory {
	
	
	public LockItDeviceFactory() {
		super();
	}
	
	
	public LockItDevice getLockItDevice(String lockItDeviceName){  
        
		if(lockItDeviceName == null){  
			return null;  
        }  
		
		if(lockItDeviceName.equalsIgnoreCase("LOCKEYE")) {  
			return new LockEye();  
           }   
		else if(lockItDeviceName.equalsIgnoreCase("LOCKSENSE")){  
            return new LockSense();  
        }   
		
		return null;  
	}  

}
