package com.lockit.entity;


import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="locksense")
public class LockSense implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="locksenseID", unique = true)
	private int locksenseID;
	
	
	@Column(name="senseLocation")
	private String senseLocation;
	
	
	@Column(name="senseLevel")
	private String senseLevel;
	
	public LockSense(String senseLocation, String senseLevel, List<SensorData> sensorData,
			List<SenseNotification> senseNotification) {
		super();
		this.senseLocation = senseLocation;
		this.senseLevel = senseLevel;
		this.sensorData = sensorData;
		this.senseNotification = senseNotification;
	}

	public LockSense(String senseLocation, String senseLevel, DeviceCode deviceCode_LockSense, House house_LockSense,
			List<SensorData> sensorData, List<SenseNotification> senseNotification) {
		super();
		this.senseLocation = senseLocation;
		this.senseLevel = senseLevel;
		this.deviceCode_LockSense = deviceCode_LockSense;
		this.house_LockSense = house_LockSense;
		this.sensorData = sensorData;
		this.senseNotification = senseNotification;
	}

	@Override
	public String toString() {
		return "LockSense [locksenseID=" + locksenseID + ", senseLocation=" + senseLocation + ", senseLevel="
				+ senseLevel + ", deviceCode_LockSense=" + deviceCode_LockSense + ", house_LockSense=" + house_LockSense
				+ ", sensorData=" + sensorData + ", senseNotification=" + senseNotification + "]";
	}

	public int getLocksenseID() {
		return locksenseID;
	}

	public void setLocksenseID(int locksenseID) {
		this.locksenseID = locksenseID;
	}

	public String getSenseLocation() {
		return senseLocation;
	}

	public void setSenseLocation(String senseLocation) {
		this.senseLocation = senseLocation;
	}

	public String getSenseLevel() {
		return senseLevel;
	}

	public void setSenseLevel(String senseLevel) {
		this.senseLevel = senseLevel;
	}

	public DeviceCode getDeviceCode_LockSense() {
		return deviceCode_LockSense;
	}

	public void setDeviceCode_LockSense(DeviceCode deviceCode_LockSense) {
		this.deviceCode_LockSense = deviceCode_LockSense;
	}

	public House getHouse_LockSense() {
		return house_LockSense;
	}

	public void setHouse_LockSense(House house_LockSense) {
		this.house_LockSense = house_LockSense;
	}

	public List<SensorData> getSensorData() {
		return sensorData;
	}

	public void setSensorData(List<SensorData> sensorData) {
		this.sensorData = sensorData;
	}

	public List<SenseNotification> getSenseNotification() {
		return senseNotification;
	}

	public void setSenseNotification(List<SenseNotification> senseNotification) {
		this.senseNotification = senseNotification;
	}

	//LockSense owner DeviceCode with relation one to one
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "key", nullable = false)
	DeviceCode deviceCode_LockSense;
	
	//LockSense owner House with relation many to one
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "houseID", nullable = false)
	House house_LockSense;
	
	//LockSense borrow from SensorData with relation one to many
	@OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "lockSense_SensorData")
	private List<SensorData> sensorData = new ArrayList<>();
	
	//LockSense borrow from SenseNotification with relation one to many
	@OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "lockSense_SenseNotification")
	private List<SenseNotification> senseNotification = new ArrayList<>();
}