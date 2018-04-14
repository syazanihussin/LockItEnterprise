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
	
	//ni utk pinjam relationship
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "houseOwner_House")
	House house;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "houseOwner_SenseNotification")
	private List<SenseNotification> senseNotification = new ArrayList<>();
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "houseOwner_EyeNotification")
	private List<EyeNotification> eyeNotification = new ArrayList<>();


	public HouseOwner() {
		super();
	}


	public HouseOwner(String userName, String password, String email, String ic, String phoneNumber) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.ic = ic;
		this.phoneNumber = phoneNumber;
	}


	public HouseOwner(String userName, String password, String email, String ic, String phoneNumber,
			House house, List<SenseNotification> senseNotification, List<EyeNotification> eyeNotification) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.ic = ic;
		this.phoneNumber = phoneNumber;
		this.house = house;
		this.senseNotification = senseNotification;
		this.eyeNotification = eyeNotification;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getIc() {
		return ic;
	}


	public void setIc(String ic) {
		this.ic = ic;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public House getHouse() {
		return house;
	}


	public void setHouse(House house) {
		this.house = house;
	}


	public List<SenseNotification> getSenseNotification() {
		return senseNotification;
	}


	public void setSenseNotification(List<SenseNotification> senseNotification) {
		this.senseNotification = senseNotification;
	}


	public List<EyeNotification> getEyeNotification() {
		return eyeNotification;
	}


	public void setEyeNotification(List<EyeNotification> eyeNotification) {
		this.eyeNotification = eyeNotification;
	}


	@Override
	public String toString() {
		return "HouseOwner [userID=" + userID + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", ic=" + ic + ", phoneNumber=" + phoneNumber + ", house=" + house + ", senseNotification="
				+ senseNotification + ", eyeNotification=" + eyeNotification + "]";
	}

}
