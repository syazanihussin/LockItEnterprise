
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
@Table(name="sensenotification")
public class SenseNotification implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="senseNotificationID", unique = true)
	private int senseNotificationID;
	
	
	@Column(name="senseNotificationTitle")
	private String senseNotificationTitle;
	
	
	@Column(name="senseNotificationDesc")
	private String senseNotificationDesc;
	
	
	@Column(name="senseTimestamp")
	private int senseTimestamp;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lockSenseID", nullable = false)
	LockSense lockSense_SenseNotification;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", nullable = false)
	HouseOwner houseOwner_SenseNotification;
	
	
	public SenseNotification() {
		super();
	}
	
	
	public SenseNotification(String senseNotificationTitle, String senseNotificationDesc, int senseTimestamp) {
		super();
		this.senseNotificationTitle = senseNotificationTitle;
		this.senseNotificationDesc = senseNotificationDesc;
		this.senseTimestamp = senseTimestamp;
	}
	

	public SenseNotification(String senseNotificationTitle, String senseNotificationDesc, int senseTimestamp,
			LockSense lockSense_SenseNotification, HouseOwner houseOwner_SenseNotification) {
		super();
		this.senseNotificationTitle = senseNotificationTitle;
		this.senseNotificationDesc = senseNotificationDesc;
		this.senseTimestamp = senseTimestamp;
		this.lockSense_SenseNotification = lockSense_SenseNotification;
		this.houseOwner_SenseNotification = houseOwner_SenseNotification;
	}


	public int getSenseNotificationID() {
		return senseNotificationID;
	}
	

	public void setSenseNotificationID(int senseNotificationID) {
		this.senseNotificationID = senseNotificationID;
	}
	

	public String getSenseNotificationTitle() {
		return senseNotificationTitle;
	}

	
	public void setSenseNotificationTitle(String senseNotificationTitle) {
		this.senseNotificationTitle = senseNotificationTitle;
	}

	
	public String getSenseNotificationDesc() {
		return senseNotificationDesc;
	}

	
	public void setSenseNotificationDesc(String senseNotificationDesc) {
		this.senseNotificationDesc = senseNotificationDesc;
	}

	
	public int getSenseTimestamp() {
		return senseTimestamp;
	}

	
	public void setSenseTimestamp(int senseTimestamp) {
		this.senseTimestamp = senseTimestamp;
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
	
	
	@Override
	public String toString() {
		return "SenseNotification [SenseNotificationID=" + senseNotificationID + ", SenseNotificationTitle="
				+ senseNotificationTitle + ", SenseNotificationDesc=" + senseNotificationDesc + ", SenseTimestamp="
				+ senseTimestamp + ", lockSense_SenseNotification=" + lockSense_SenseNotification
				+ ", houseOwner_SenseNotification=" + houseOwner_SenseNotification + "]";
	}
	
}