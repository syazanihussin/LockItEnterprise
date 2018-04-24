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
@Table(name="sensordata")
public class SensorData implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dataID", unique = true)
	private int dataID;
	
	
	@Column(name="dataTimestamp")
	private int dataTimestamp;
	
	
	@Column(name="data")
	private double data;
	
	
	//SensorData owner LockSense with relation many to one
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lockSenseID", nullable = false)
	LockSense lockSense_SensorData;
	
	
	public SensorData() {
		super();
	}
	
	
	public SensorData(int dataTimestamp, double data) {
		super();
		this.dataTimestamp = dataTimestamp;
		this.data = data;
	}

	
	public SensorData(int dataTimestamp, double data, LockSense lockSense_SensorData) {
		super();
		this.dataTimestamp = dataTimestamp;
		this.data = data;
		this.lockSense_SensorData = lockSense_SensorData;
	}

	
	public int getDataID() {
		return dataID;
	}
	

	public void setDataID(int dataID) {
		this.dataID = dataID;
	}
	

	public int getDataTimestamp() {
		return dataTimestamp;
	}
	

	public void setDataTimestamp(int dataTimestamp) {
		this.dataTimestamp = dataTimestamp;
	}
	

	public double getData() {
		return data;
	}
	

	public void setData(double data) {
		this.data = data;
	}
	

	public LockSense getLockSense_SensorData() {
		return lockSense_SensorData;
	}

	
	public void setLockSense_SensorData(LockSense lockSense_SensorData) {
		this.lockSense_SensorData = lockSense_SensorData;
	}


	@Override
	public String toString() {
		return "SensorData [dataID=" + dataID + ", dataTimestamp=" + dataTimestamp + ", data=" + data + "]";
	}
	
}
