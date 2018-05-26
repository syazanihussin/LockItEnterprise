package com.lockit.interfaces;


import com.lockit.entity.DeviceCode;
import com.lockit.entity.House;


public interface LockItDevice {

	void save(String level, String location, DeviceCode keyz, House houseID);	

}
