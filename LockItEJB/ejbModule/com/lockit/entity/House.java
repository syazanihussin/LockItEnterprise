package com.lockit.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="house")
public class House implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private HouseOwner houseOwnerDetail;
	
	
	@Id
	@Column(name="houseID", unique = true)
	private int houseID;
	
	
	@Column(name="address")
	private String address;
	
	
	@Column(name="houseBlueprint")
	private String houseBlueprint;

	
	public House() {
		super();
	}
	
	
	public House(String address, String houseBlueprint) {
		super();
		this.address = address;
		this.houseBlueprint = houseBlueprint;
	}
	
	
	public House(int houseID, String address, String houseBlueprint) {
		super();
		this.houseID = houseID;
		this.address = address;
		this.houseBlueprint = houseBlueprint;
	}
	
	
	public House(int houseID, String address, String houseBlueprint, HouseOwner houseOwnerDetail) {
		super();
		this.houseID = houseID;
		this.address = address;
		this.houseBlueprint = houseBlueprint;
		this.houseOwnerDetail = houseOwnerDetail;
	}
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID")
    public HouseOwner getHouseDetail() {
        return houseOwnerDetail;
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
	

	@Override
	public String toString() {
		return "House [houseID=" + houseID + ", address=" + address + ", houseBlueprint=" + houseBlueprint + "]";
	}
}

