package com.lockit.ejb.logic.remote;


import javax.ejb.Remote;


@Remote
public interface DeviceCodeLogicRemote {

	Boolean verifyDeviceCode(String code);
	String determineDeviceType(String code);
	
}
