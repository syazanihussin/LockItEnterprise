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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="houseowner")
public class HouseOwner implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userID", unique = true)
	private String userID;
	
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	
	@Column(name="email")
	private String email;
	
	
	@Column(name="ic")
	private String ic;
	
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "houseOwner_House")
	House house;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "houseOwner_SenseNotification")
	private List<SenseNotification> senseNotification = new ArrayList<>();
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "houseOwner_EyeNotification")
	private List<EyeNotification> eyeNotification = new ArrayList<>();


	public HouseOwner() {
		super();
	}
	
	
	

}
