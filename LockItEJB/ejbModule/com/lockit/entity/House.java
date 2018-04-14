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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="houseID", unique = true)
	private int houseID;
	
	
	@Column(name="address")
	private String address;
	
	
	@Column(name="houseBlueprint")
	private String houseBlueprint;
	
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", nullable = false)
	HouseOwner houseOwner_House;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "house_LockEye")
	private List<LockEye> lockEye = new ArrayList<>();
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "house_LockSense")
	private List<LockSense> lockSense = new ArrayList<>();
	
	
	public House() {
		super();
	}
	
	
	
}

