package com.lockit.entity;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="eyeNotification")
public class EyeNotification implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="eyeNotificationID", unique = true)
	private int eyeNotificationID;
	
	
	@Column(name="eyeNotificationTitle")
	private String eyeNotificationTitle;
	
	
	@Column(name="eyeNotificationDesc")
	private String eyeNotificationDesc;
	
	
	@Column(name="eyeTimestamp")
	private long eyeTimestamp;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lockEyeID", nullable = false)
	LockEye lockEye_EyeNotification;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", nullable = false)
	HouseOwner houseOwner_EyeNotification;
	
	
	public EyeNotification() {
		super();
	}
	
	
	public EyeNotification(String eyeNotificationTitle, String eyeNotificationDesc, int eyeTimestamp) {
		super();
		this.eyeNotificationTitle = eyeNotificationTitle;
		this.eyeNotificationDesc = eyeNotificationDesc;
		this.eyeTimestamp = eyeTimestamp;
	}
	
	
	public EyeNotification(String eyeNotificationTitle, String eyeNotificationDesc, int eyeTimestamp,
			LockEye lockEye_EyeNotification, HouseOwner houseOwner_EyeNotification) {
		super();
		this.eyeNotificationTitle = eyeNotificationTitle;
		this.eyeNotificationDesc = eyeNotificationDesc;
		this.eyeTimestamp = eyeTimestamp;
		this.lockEye_EyeNotification = lockEye_EyeNotification;
		this.houseOwner_EyeNotification = houseOwner_EyeNotification;
	}

	
	public int getEyeNotificationID() {
		return eyeNotificationID;
	}

	
	public void setEyeNotificationID(int eyeNotificationID) {
		this.eyeNotificationID = eyeNotificationID;
	}

	
	public String getEyeNotificationTitle() {
		return eyeNotificationTitle;
	}

	
	public void setEyeNotificationTitle(String eyeNotificationTitle) {
		this.eyeNotificationTitle = eyeNotificationTitle;
	}
	

	public String getEyeNotificationDesc() {
		return eyeNotificationDesc;
	}
	

	public void setEyeNotificationDesc(String eyeNotificationDesc) {
		this.eyeNotificationDesc = eyeNotificationDesc;
	}

	
	public long getEyeTimestamp() {
		return eyeTimestamp;
	}
	

	public void setEyeTimestamp(long eyeTimestamp) {
		this.eyeTimestamp = eyeTimestamp;
	}

	
	public LockEye getLockEye_EyeNotification() {
		return lockEye_EyeNotification;
	}
	

	public void setLockEye_EyeNotification(LockEye lockEye_EyeNotification) {
		this.lockEye_EyeNotification = lockEye_EyeNotification;
	}
	

	public HouseOwner getHouseOwner_EyeNotification() {
		return houseOwner_EyeNotification;
	}

	
	public void setHouseOwner_EyeNotification(HouseOwner houseOwner_EyeNotification) {
		this.houseOwner_EyeNotification = houseOwner_EyeNotification;
	}


	@Override
	public String toString() {
		return "EyeNotification [eyeNotificationID=" + eyeNotificationID + ", eyeNotificationTitle="
				+ eyeNotificationTitle + ", eyeNotificationDesc=" + eyeNotificationDesc + ", eyeTimestamp="
				+ eyeTimestamp + "]";
	}

}