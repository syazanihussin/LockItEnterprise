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
	@Column(name="keyz", unique = true)
	private String keyz;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deviceID", nullable = false)
	DeviceInfo deviceInfo_DeviceCode;
	
	
	@OneToOne(cascade =  CascadeType.ALL, mappedBy = "deviceCode_LockEye")
	private LockEye lockEye;
	
	
	@OneToOne(cascade =  CascadeType.ALL, mappedBy = "deviceCode_LockSense")
	private LockSense lockSense;


	public DeviceCode() {
		super();
	}


	public DeviceCode(String keyz) {
		super();
		this.keyz = keyz;
	}


	public DeviceCode(String keyz, DeviceInfo deviceInfo_DeviceCode) {
		super();
		this.keyz = keyz;
		this.deviceInfo_DeviceCode = deviceInfo_DeviceCode;
	}


	public String getKeyz() {
		return keyz;
	}


	public void setKeyz(String keyz) {
		this.keyz = keyz;
	}


	public DeviceInfo getDeviceInfo_DeviceCode() {
		return deviceInfo_DeviceCode;
	}


	public void setDeviceInfo_DeviceCode(DeviceInfo deviceInfo_DeviceCode) {
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
		return "DeviceCode [keyz=" + keyz + "]";
	}
	
}

