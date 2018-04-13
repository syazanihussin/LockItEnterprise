package com.lockit.entity;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class HouseOwner implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	House house;
	

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


	public HouseOwner() {
		super();
	}
	
	
	public HouseOwner(String userID, String userName, String password, String email, String ic, String phoneNumber) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.ic = ic;
		this.phoneNumber = phoneNumber;
	}
	
	
	@OneToOne(mappedBy = "houseOwnerDetail")
    public House getHouseOwner() {
        return house;
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


	@Override
	public String toString() {
		return "HouseOwner [userID=" + userID + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", ic=" + ic + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
