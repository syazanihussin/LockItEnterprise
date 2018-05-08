package com.lockit.ejb.dao.local;


import java.util.List;
import javax.ejb.Local;
import com.lockit.entity.DeviceCode;


@Local
public interface DeviceCodeBeanLocal {

	void insertDeviceCode(DeviceCode deviceCode);
	DeviceCode getDeviceCodeByKey(String key);
	List<DeviceCode> getAllDeviceCodes();
	void updateDeviceCode(DeviceCode deviceCode);
	void deleteDeviceCode(String key);
	void deleteAllDeviceCodes();

}
