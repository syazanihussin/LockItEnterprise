package com.lockit.ejb.dao;


import java.util.List;
import javax.ejb.Remote;
import com.lockit.entity.DeviceCode;


@Remote
public interface DeviceCodeBeanRemote {
	
	void insertDeviceCode(DeviceCode deviceCode);
	DeviceCode getDeviceCodeByKey(String key);
	List<DeviceCode> getAllDeviceCodes();
	void updateDeviceCode(DeviceCode deviceCode);
	void deleteDeviceCode(String key);
	void deleteAllDeviceCodes();

}
