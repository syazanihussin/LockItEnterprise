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
	
	
	
	
}

