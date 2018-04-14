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
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="EyeNotification")
public class EyeNotification implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EyeNotificationID", unique = true)
	private int EyeNotificationID;
	
	
	@Column(name="EyeNotificationTitle")
	private String EyeNotificationTitle;
	
	
	@Column(name="EyeNotificationDesc")
	private String EyeNotificationDesc;
	
	@Column(name="EyeTimestamp")
	private int EyeTimestamp;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lockEyeID", nullable = false)
	
	LockEye lockEye_EyeNotification;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", nullable = false)
	
	HouseOwner houseOwner_EyeNotification;

	public int getEyeNotificationID() {
		return EyeNotificationID;
	}

	public void setEyeNotificationID(int eyeNotificationID) {
		EyeNotificationID = eyeNotificationID;
	}

	public String getEyeNotificationTitle() {
		return EyeNotificationTitle;
	}

	public void setEyeNotificationTitle(String eyeNotificationTitle) {
		EyeNotificationTitle = eyeNotificationTitle;
	}

	public String getEyeNotificationDesc() {
		return EyeNotificationDesc;
	}

	public void setEyeNotificationDesc(String eyeNotificationDesc) {
		EyeNotificationDesc = eyeNotificationDesc;
	}

	public int getEyeTimestamp() {
		return EyeTimestamp;
	}

	public void setEyeTimestamp(int eyeTimestamp) {
		EyeTimestamp = eyeTimestamp;
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
		return "EyeNotification [EyeNotificationID=" + EyeNotificationID + ", EyeNotificationTitle="
				+ EyeNotificationTitle + ", EyeNotificationDesc=" + EyeNotificationDesc + ", EyeTimestamp="
				+ EyeTimestamp + ", lockEye_EyeNotification=" + lockEye_EyeNotification
				+ ", houseOwner_EyeNotification=" + houseOwner_EyeNotification + "]";
	}

	public EyeNotification(String eyeNotificationTitle, String eyeNotificationDesc, int eyeTimestamp,
			LockEye lockEye_EyeNotification, HouseOwner houseOwner_EyeNotification) {
		super();
		EyeNotificationTitle = eyeNotificationTitle;
		EyeNotificationDesc = eyeNotificationDesc;
		EyeTimestamp = eyeTimestamp;
		this.lockEye_EyeNotification = lockEye_EyeNotification;
		this.houseOwner_EyeNotification = houseOwner_EyeNotification;
	}

	public EyeNotification(String eyeNotificationTitle, String eyeNotificationDesc, int eyeTimestamp) {
		super();
		EyeNotificationTitle = eyeNotificationTitle;
		EyeNotificationDesc = eyeNotificationDesc;
		EyeTimestamp = eyeTimestamp;
	}
}