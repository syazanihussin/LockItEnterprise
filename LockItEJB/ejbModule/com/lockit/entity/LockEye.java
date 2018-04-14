package com.lockit.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
@Table(name="LockEye")
public class LockEye implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LockEyeID", unique = true)
	private int LockEyeID;
	
	@Column(name="EyeLocation")
	private String EyeLocation;
	
	@Column(name="EyeLevel")
	private String EyeLevel;
	
	
//relation starts here 1-1 or N-1 or 1-N
	
	//relation owner of relation
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HouseID", nullable = false)
	House house_LockEye;//fkey


	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "key", nullable = false)
    DeviceCode deviceCode_LockEye;//fkey
	
	
	
	//borrower of relation
	@OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "lockEye_Video")//map: fk from many erd
	private List<Video> video= new ArrayList<>();
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "lockEye_EyeNotification") //map:fk from many erd
	private List<EyeNotification> EyeNotification =new ArrayList<>();
	
	
	
	public LockEye(){
	super();
	
	
}



	public int getLockEyeID() {
		return LockEyeID;
	}



	public void setLockEyeID(int lockEyeID) {
		LockEyeID = lockEyeID;
	}



	public String getEyeLocation() {
		return EyeLocation;
	}



	public void setEyeLocation(String eyeLocation) {
		EyeLocation = eyeLocation;
	}



	public String getEyeLevel() {
		return EyeLevel;
	}



	public void setEyeLevel(String eyeLevel) {
		EyeLevel = eyeLevel;
	}



	public House getHouse_LockEye() {
		return house_LockEye;
	}



	public void setHouse_LockEye(House house_LockEye) {
		this.house_LockEye = house_LockEye;
	}



	public DeviceCode getDeviceCode_LockEye() {
		return deviceCode_LockEye;
	}



	public void setDeviceCode_LockEye(DeviceCode deviceCode_LockEye) {
		this.deviceCode_LockEye = deviceCode_LockEye;
	}



	public List<Video> getVideo() {
		return video;
	}



	public void setVideo(List<Video> video) {
		this.video = video;
	}



	public List<EyeNotification> getEyeNotification() {
		return EyeNotification;
	}



	public void setEyeNotification(List<EyeNotification> eyeNotification) {
		EyeNotification = eyeNotification;
	}



	public LockEye(String eyeLocation, String eyeLevel, List<Video> video,
			List<com.lockit.entity.EyeNotification> eyeNotification) {
		super();
		EyeLocation = eyeLocation;
		EyeLevel = eyeLevel;
		this.video = video;
		EyeNotification = eyeNotification;
	}



	public LockEye(int lockEyeID, String eyeLocation, String eyeLevel, House house_LockEye,
			DeviceCode deviceCode_LockEye, List<Video> video, List<com.lockit.entity.EyeNotification> eyeNotification) {
		super();
		LockEyeID = lockEyeID;
		EyeLocation = eyeLocation;
		EyeLevel = eyeLevel;
		this.house_LockEye = house_LockEye;
		this.deviceCode_LockEye = deviceCode_LockEye;
		this.video = video;
		EyeNotification = eyeNotification;
	}



	@Override
	public String toString() {
		return "LockEye [LockEyeID=" + LockEyeID + ", EyeLocation=" + EyeLocation + ", EyeLevel=" + EyeLevel
				+ ", house_LockEye=" + house_LockEye + ", deviceCode_LockEye=" + deviceCode_LockEye + ", video=" + video
				+ ", EyeNotification=" + EyeNotification + "]";
	}
}