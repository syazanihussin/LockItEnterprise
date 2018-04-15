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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="house")
public class House implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="houseID", unique = true)
	private int houseID;
	
	
	@Column(name="address")
	private String address;
	
	
	@Column(name ="houseBlueprint")
	private String houseBlueprint;
	
	
	@OneToOne(fetch = FetchType.LAZY, targetEntity = HouseOwner.class)
    @JoinColumn(name = "userID", nullable = false)
	HouseOwner houseOwner_House;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "house_LockEye")
	private List<LockEye> lockEye = new ArrayList<>();
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "house_LockSense")
	private List<LockSense> lockSense = new ArrayList<>();
	
	
	public House() {
		super();
	}


	public House(int houseID, String address, String houseBlueprint) {
		super();
		this.houseID = houseID;
		this.address = address;
		this.houseBlueprint = houseBlueprint;
	}
	
	
	public House(String address, String houseBlueprint) {
		super();
		this.address = address;
		this.houseBlueprint = houseBlueprint;
	}
	
	
	public House(String address, String houseBlueprint, HouseOwner houseOwner_House) {
		super();
		this.address = address;
		this.houseBlueprint = houseBlueprint;
		this.houseOwner_House = houseOwner_House;
	}


	public int getHouseID() {
		return houseID;
	}


	public void setHouseID(int houseID) {
		this.houseID = houseID;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getHouseBlueprint() {
		return houseBlueprint;
	}


	public void setHouseBlueprint(String houseBlueprint) {
		this.houseBlueprint = houseBlueprint;
	}


	public HouseOwner getHouseOwner_House() {
		return houseOwner_House;
	}


	public void setHouseOwner_House(HouseOwner houseOwner_House) {
		this.houseOwner_House = houseOwner_House;
	}


	public List<LockEye> getLockEye() {
		return lockEye;
	}


	public void setLockEye(List<LockEye> lockEye) {
		this.lockEye = lockEye;
	}


	public List<LockSense> getLockSense() {
		return lockSense;
	}


	public void setLockSense(List<LockSense> lockSense) {
		this.lockSense = lockSense;
	}


	@Override
	public String toString() {
		return "House [houseID=" + houseID + ", address=" + address + ", houseBlueprint=" + houseBlueprint
				+ ", houseOwner_House=" + houseOwner_House + ", lockEye=" + lockEye + ", lockSense=" + lockSense + "]";
	}
	
}

