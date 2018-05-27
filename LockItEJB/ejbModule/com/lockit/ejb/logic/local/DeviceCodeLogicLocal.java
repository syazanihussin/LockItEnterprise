package com.lockit.ejb.logic.local;


import javax.ejb.Local;


@Local
public interface DeviceCodeLogicLocal {
	
	Boolean verifyDeviceCode(String code);
	String determineDeviceType(String code);

}
