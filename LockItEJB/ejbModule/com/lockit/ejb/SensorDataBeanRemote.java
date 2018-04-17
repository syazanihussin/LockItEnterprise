package com.lockit.ejb;


import java.util.List;
import javax.ejb.Remote;
import com.lockit.entity.SensorData;


@Remote
public interface SensorDataBeanRemote {

	void insertSensorData(SensorData sensorData);
	SensorData getSensorDataById(int id);
	List<SensorData> getAllSensorDatas();
	void updateSensorData(SensorData sensorData);
	void deleteSensorData(int id);
	void deleteAllSensorDatas();
}
