package com.lockit.ejb.dao.local;


import java.util.List;
import javax.ejb.Local;
import com.lockit.entity.DeviceInfo;


@Local
public interface DeviceInfoBeanLocal {

	void insertHouse(DeviceInfo deviceInfo);
	DeviceInfo getDeviceInfoById(int id);
	List<DeviceInfo> getAllDeviceInfos();
	void updateDeviceInfo(DeviceInfo deviceInfo);
	void deleteDeviceInfo(int id);
	void deleteAllDeviceInfos();

}
