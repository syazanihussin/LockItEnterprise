package com.lockit.ejb;


import java.util.List;
import javax.ejb.Remote;
import com.lockit.entity.DeviceInfo;


@Remote
public interface DeviceInfoBeanRemote {

	void insertHouse(DeviceInfo deviceInfo);
	DeviceInfo getDeviceInfoById(int id);
	List<DeviceInfo> getAllDeviceInfos();
	void updateDeviceInfo(DeviceInfo deviceInfo);
	void deleteDeviceInfo(int id);
	void deleteAllDeviceInfos();
	
}
