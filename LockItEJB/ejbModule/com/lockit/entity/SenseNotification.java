
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
@Table(name="SenseNotification")
public class SenseNotification implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SenseNotificationID", unique = true)
	private int SenseNotificationID;
	
	
	public SenseNotification(String senseNotificationTitle, String senseNotificationDesc, int senseTimestamp) {
		super();
		SenseNotificationTitle = senseNotificationTitle;
		SenseNotificationDesc = senseNotificationDesc;
		SenseTimestamp = senseTimestamp;
	}

	public SenseNotification(String senseNotificationTitle, String senseNotificationDesc, int senseTimestamp,
			LockSense lockSense_SenseNotification, HouseOwner houseOwner_SenseNotification) {
		super();
		SenseNotificationTitle = senseNotificationTitle;
		SenseNotificationDesc = senseNotificationDesc;
		SenseTimestamp = senseTimestamp;
		this.lockSense_SenseNotification = lockSense_SenseNotification;
		this.houseOwner_SenseNotification = houseOwner_SenseNotification;
	}

	@Override
	public String toString() {
		return "SenseNotification [SenseNotificationID=" + SenseNotificationID + ", SenseNotificationTitle="
				+ SenseNotificationTitle + ", SenseNotificationDesc=" + SenseNotificationDesc + ", SenseTimestamp="
				+ SenseTimestamp + ", lockSense_SenseNotification=" + lockSense_SenseNotification
				+ ", houseOwner_SenseNotification=" + houseOwner_SenseNotification + "]";
	}

	public int getSenseNotificationID() {
		return SenseNotificationID;
	}

	public void setSenseNotificationID(int senseNotificationID) {
		SenseNotificationID = senseNotificationID;
	}

	public String getSenseNotificationTitle() {
		return SenseNotificationTitle;
	}

	public void setSenseNotificationTitle(String senseNotificationTitle) {
		SenseNotificationTitle = senseNotificationTitle;
	}

	public String getSenseNotificationDesc() {
		return SenseNotificationDesc;
	}

	public void setSenseNotificationDesc(String senseNotificationDesc) {
		SenseNotificationDesc = senseNotificationDesc;
	}

	public int getSenseTimestamp() {
		return SenseTimestamp;
	}

	public void setSenseTimestamp(int senseTimestamp) {
		SenseTimestamp = senseTimestamp;
	}

	public LockSense getLockSense_SenseNotification() {
		return lockSense_SenseNotification;
	}

	public void setLockSense_SenseNotification(LockSense lockSense_SenseNotification) {
		this.lockSense_SenseNotification = lockSense_SenseNotification;
	}

	public HouseOwner getHouseOwner_SenseNotification() {
		return houseOwner_SenseNotification;
	}

	public void setHouseOwner_SenseNotification(HouseOwner houseOwner_SenseNotification) {
		this.houseOwner_SenseNotification = houseOwner_SenseNotification;
	}

	@Column(name="SenseNotificationTitle")
	private String SenseNotificationTitle;
	
	
	@Column(name="SenseNotificationDesc")
	private String SenseNotificationDesc;
	
	@Column(name="SenseTimestamp")
	private int SenseTimestamp;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lockSenseID", nullable = false)
	
	LockSense lockSense_SenseNotification;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", nullable = false)
	
	HouseOwner houseOwner_SenseNotification;
}