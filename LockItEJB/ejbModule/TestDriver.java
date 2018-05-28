import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.lockit.ejb.DeviceCodeBean;
import com.lockit.ejb.EyeNotificationBean;
import com.lockit.ejb.HouseOwnerBean;
import com.lockit.ejb.LockEyeBean;
import com.lockit.ejb.LockSenseBean;
import com.lockit.ejb.NotificationBean;
import com.lockit.ejb.SenseNotificationBean;
import com.lockit.ejb.SensorDataBean;
import com.lockit.ejb.VideoBean;
import com.lockit.ejb.dao.local.DeviceCodeBeanLocal;
import com.lockit.ejb.dao.local.EyeNotificationBeanLocal;
import com.lockit.ejb.dao.local.LockEyeBeanLocal;
import com.lockit.ejb.dao.local.LockSenseBeanLocal;
import com.lockit.ejb.dao.local.SenseNotificationBeanLocal;
import com.lockit.ejb.dao.local.SensorDataBeanLocal;
import com.lockit.ejb.dao.local.VideoBeanLocal;
import com.lockit.ejb.logic.local.DeviceCodeLogicLocal;
import com.lockit.ejb.logic.local.EyeNotificationLogicLocal;
import com.lockit.ejb.logic.local.LockEyeLogicLocal;
import com.lockit.ejb.logic.local.LockSenseLogicLocal;
import com.lockit.ejb.logic.local.NotificationLogicLocal;
import com.lockit.ejb.logic.local.SenseNotificationLogicLocal;
import com.lockit.ejb.logic.local.SensorDataLogicLocal;
import com.lockit.ejb.logic.local.VideoLogicLocal;
import com.lockit.entity.DeviceCode;
import com.lockit.entity.DeviceInfo;
import com.lockit.entity.EyeNotification;
import com.lockit.entity.House;
import com.lockit.entity.HouseOwner;
import com.lockit.entity.LockEye;
import com.lockit.entity.LockSense;
import com.lockit.entity.SenseNotification;
import com.lockit.entity.SensorData;
import com.lockit.entity.Video;
import com.lockit.factory.LockItDeviceFactory;

public class TestDriver {

	public static void main(String[] args) {
				  
		
		/*//INSERT
		HouseOwnerBean houseOwnerBean = new HouseOwnerBean();
		HouseOwner houseOwner = new HouseOwner("syazanihussin", "spectrum", "syazanihussin@gmail.com", "961225-10-5835", "017-3852095");
		House house = new House("Lot254 Kampung Katong", "C://image/house.png", houseOwner);
		houseOwner.setHouse(house);
		houseOwnerBean.insertHouseOwner(houseOwner);
		
		
		//UPDATE
		houseOwner.setEmail("syazani00@gmail.com");
		houseOwnerBean.updateHouseOwner(houseOwner);
		
		
		//SELECT
		HouseOwner houseOwner2 = houseOwnerBean.getHouseOwnerById(39);
		System.out.println(houseOwner2.toString());
		System.out.println(houseOwner2.getEmail());
		
		
		//SELECT ALL HOUSES
		for(HouseOwner houseOwner3 : houseOwnerBean.getAllHouseOwners()) {
			System.out.println(houseOwner3.getEmail());
		}
		
		
		//DELECT
		
		
		//DELECT ALL HOUSES
		
		
		//NOTIFICATION
		NotificationLogicLocal notificationLogicLocal = new NotificationBean();
		EyeNotificationBeanLocal eyeNotificationBeanLocal = new EyeNotificationBean();
		EyeNotificationLogicLocal eyeNotificationLogicLocal = new EyeNotificationBean();
		SenseNotificationBeanLocal senseNotificationBeanLocal = new SenseNotificationBean();
		SenseNotificationLogicLocal senseNotificationLogicLocal = new SenseNotificationBean();
		
		System.out.println(notificationLogicLocal.calculateTotalNotifications());
		
		for(EyeNotification eye : eyeNotificationBeanLocal.getAllEyeNotifications()) {
			System.out.println(eyeNotificationLogicLocal.getEyeNotificationInterval(eye));
		}
		
		for(SenseNotification sense : senseNotificationBeanLocal.getAllSenseNotifications()) {
			System.out.println(senseNotificationLogicLocal.getSenseNotificationInterval(sense));
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");  
	    Date date = new Date(); 
	    String df = formatter.format(date);  
	    long currentTimestamp = Long.parseLong(df);
	    System.out.println(currentTimestamp);
		
		
		/*VideoLogicLocal videoLogicLocal = new VideoBean();
		VideoBeanLocal videoBeanLocal = new VideoBean();
		LockEye lockEye = new LockEye();
		lockEye.setLockEyeID(1);												  
		Video video = new Video(Long.parseLong("27052018084732"), Long.parseLong(df), "abu", 0.2, lockEye);
		videoBeanLocal.insertVideo(video);
		
		System.out.println(videoLogicLocal.calculateRemainingSpace());
		System.out.println(videoLogicLocal.calculateTotalVideo());
		
		
		SensorDataBeanLocal sensorDataBeanLocal = new SensorDataBean();
		LockSense lockSense = new LockSense();
		lockSense.setLocksenseID(1);
		SensorData sensorData = new SensorData(Long.parseLong(df), 400, lockSense);
		sensorDataBeanLocal.insertSensorData(sensorData);
		
		
	    SensorDataLogicLocal SensorDataLogicLocal = new SensorDataBean();
	    HashMap<SensorData, LockSense> hm = SensorDataLogicLocal.detectUnusualData();
	    System.out.println(hm.size());
	    for(Map.Entry m : hm.entrySet()){  
	   	   System.out.println(m.getKey()+" "+m.getValue());  
	    }  
		
		DeviceCodeBeanLocal bl = new DeviceCodeBean();
		DeviceInfo deviceInfo = new DeviceInfo();
		deviceInfo.setDeviceID(1);
		DeviceCode deviceCode = new DeviceCode("kaka", deviceInfo);
		bl.insertDeviceCode(deviceCode);
		
		DeviceCodeLogicLocal bl = new DeviceCodeBean();
		System.out.println(bl.determineDeviceType("XYZ"));
		
		LockEyeLogicLocal le = new LockEyeBean();
		HashMap<Video, LockEye> hm = le.checkLockEyeStatus();
		for(Map.Entry m : hm.entrySet()){  
			System.out.println(m.getKey()+" "+m.getValue());  
		} 
		
		
		LockSenseLogicLocal le = new LockSenseBean();
		HashMap<SensorData, LockSense> hm = le.checkLockSenseStatus();
		for(Map.Entry m : hm.entrySet()){  
			System.out.println(m.getKey()+" "+m.getValue());  
		} 
		
		VideoBeanLocal v = new VideoBean();
		System.out.println(v.getVideoById(4).getLockEye_Video());
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");  
	    Date date = new Date(); 
	    String df = formatter.format(date);  
	    long currentTimestamp = Long.parseLong(df);
	    System.out.println(currentTimestamp);
	    
	    LockSenseLogicLocal lockSenseLogicLocal = new LockSenseBean();
	    LockSenseBeanLocal lockSenseBeanLocal = new LockSenseBean();
	    
	    
	    List<LockSense> normalLockSense = new ArrayList<>();
		List<LockSense> dangerLockSense = new ArrayList<>();
		
		for(LockSense lockSense : lockSenseBeanLocal.getAllLockSenses()){  
			HashMap<SensorData, LockSense> a = lockSenseLogicLocal.checkLockSenseStatus(lockSense.getLocksenseID());
			
			if(a.isEmpty()) {
				normalLockSense.add(lockSense);
			} else {
				for(@SuppressWarnings("rawtypes") Map.Entry m : a.entrySet()) {
					dangerLockSense.add((LockSense) m.getValue());
				}
			}
		}
		
		System.out.println(normalLockSense);
		System.out.println(dangerLockSense);
		
		LockEyeLogicLocal lockEyeLogicLocal = new LockEyeBean();
	    LockEyeBeanLocal lockEyeBeanLocal = new LockEyeBean();
		
	    List<LockEye> normalLockEye = new ArrayList<>();
		List<LockEye> dangerLockEye = new ArrayList<>();
		
		for(LockEye lockEye : lockEyeBeanLocal.getAllLockEyes()){  
			HashMap<Video, LockEye> a = lockEyeLogicLocal.checkLockEyeStatus(lockEye.getLockEyeID());
			
			if(a.isEmpty()) {
				normalLockEye.add(lockEye);
			} else {
				for(@SuppressWarnings("rawtypes") Map.Entry m : a.entrySet()) {
					dangerLockEye.add((LockEye) m.getValue());
				}
			}
		}
		
		System.out.println(normalLockEye);
		System.out.println(dangerLockEye);
		*/
		
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");  
	    Date date = new Date(); 
	    String df = formatter.format(date);  
	    long currentTimestamp = Long.parseLong(df);
	    System.out.println(currentTimestamp);
	    
		
	}

}
