package com.lockit.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.lockit.entity.DeviceCode;


@Entity
@Table(name="deviceinfo")
public class DeviceInfo implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="deviceID", unique = true)
	private int deviceID;
	
	
	@Column(name="deviceName")
	private String deviceName;
	
	
	@Column(name="deviceDesc")
	private String deviceDesc;
	
	
	@OneToMany(cascade =  CascadeType.ALL, mappedBy = "deviceInfo_DeviceCode")
	private List<DeviceCode> deviceCode = new ArrayList<>();
	
	
	public DeviceInfo() {
		super();
	}


	public DeviceInfo(String deviceName, String deviceDesc) {
		super();
		this.deviceName = deviceName;
		this.deviceDesc = deviceDesc;
	}


	public int getDeviceID() {
		return deviceID;
	}


	public void setDeviceID(int deviceID) {
		this.deviceID = deviceID;
	}


	public String getDeviceName() {
		return deviceName;
	}


	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}


	public String getDeviceDesc() {
		return deviceDesc;
	}


	public void setDeviceDesc(String deviceDesc) {
		this.deviceDesc = deviceDesc;
	}


	public List<DeviceCode> getDeviceCode() {
		return deviceCode;
	}


	public void setDeviceCode(List<DeviceCode> deviceCode) {
		this.deviceCode = deviceCode;
	}


	@Override
	public String toString() {
		return "DeviceInfo [deviceID=" + deviceID + ", deviceName=" + deviceName + ", deviceDesc=" + deviceDesc + "]";
	}
	
}