package com.lockit.entity;


import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="devicecode")
public class DeviceCode implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="key", unique = true)
	private String key;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deviceID", nullable = false)
	HouseOwner deviceInfo_DeviceCode;
	
	
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "deviceCode_LockEye")
	private LockEye lockEye;
	
	
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "deviceCode_LockSense")
	private LockSense lockSense;


	public DeviceCode() {
		super();
	}


	public DeviceCode(String key) {
		super();
		this.key = key;
	}


	public DeviceCode(String key, HouseOwner deviceInfo_DeviceCode, LockEye lockEye, LockSense lockSense) {
		super();
		this.key = key;
		this.deviceInfo_DeviceCode = deviceInfo_DeviceCode;
		this.lockEye = lockEye;
		this.lockSense = lockSense;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public HouseOwner getDeviceInfo_DeviceCode() {
		return deviceInfo_DeviceCode;
	}


	public void setDeviceInfo_DeviceCode(HouseOwner deviceInfo_DeviceCode) {
		this.deviceInfo_DeviceCode = deviceInfo_DeviceCode;
	}


	public LockEye getLockEye() {
		return lockEye;
	}


	public void setLockEye(LockEye lockEye) {
		this.lockEye = lockEye;
	}


	public LockSense getLockSense() {
		return lockSense;
	}


	public void setLockSense(LockSense lockSense) {
		this.lockSense = lockSense;
	}


	@Override
	public String toString() {
		return "DeviceCode [key=" + key + ", deviceInfo_DeviceCode=" + deviceInfo_DeviceCode + ", lockEye=" + lockEye
				+ ", lockSense=" + lockSense + "]";
	}
	
}

