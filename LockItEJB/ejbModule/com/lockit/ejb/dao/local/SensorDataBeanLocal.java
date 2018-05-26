package com.lockit.ejb.dao.local;


import java.util.List;
import javax.ejb.Local;
import com.lockit.entity.SensorData;


@Local
public interface SensorDataBeanLocal {

	void insertSensorData(SensorData sensorData);
	SensorData getSensorDataById(int id);
	List<SensorData> getAllSensorDatas();
	void updateSensorData(SensorData sensorData);
	void deleteSensorData(int id);
	void deleteAllSensorDatas();
	Boolean detectUnusualData();
	Boolean detectUnusualData(Boolean List);
	

}
