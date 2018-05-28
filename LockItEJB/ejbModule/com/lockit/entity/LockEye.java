package com.lockit.entity;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.lockit.ejb.LockEyeBean;
import com.lockit.ejb.VideoBean;
import com.lockit.interfaces.LockItDevice;


@Entity
@Table(name="lockeye")
public class LockEye implements Serializable, LockItDevice {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="lockEyeID", unique = true)
	private int lockEyeID;
	
	
	@Column(name="eyeLocation")
	private String eyeLocation;
	
	
	@Column(name="eyeLevel")
	private String eyeLevel;
	
	
//relation starts here 1-1 or N-1 or 1-N
	
	//relation owner of relation
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "houseID", nullable = false)
	House house_LockEye;//fkey


	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "keyz", nullable = false)
    DeviceCode deviceCode_LockEye;//fkey
	
	
	//borrower of relation
	@OneToMany(cascade =  CascadeType.ALL, mappedBy = "lockEye_Video") //map: fk from many erd
	private List<Video> video = new ArrayList<>();
	
	
	@OneToMany(cascade =  CascadeType.ALL, mappedBy = "lockEye_EyeNotification") //map:fk from many erd
	private List<EyeNotification> eyeNotification = new ArrayList<>();
	
	
	public LockEye(){
		super();
	}
	
	
	public LockEye(String eyeLocation, String eyeLevel) {
		super();
		this.eyeLocation = eyeLocation;
		this.eyeLevel = eyeLevel;
	}
	
	
	public LockEye(String eyeLocation, String eyeLevel, DeviceCode deviceCode_LockEye, House house_LockEye) {
		super();
		this.eyeLocation = eyeLocation;
		this.eyeLevel = eyeLevel;
		this.house_LockEye = house_LockEye;
		this.deviceCode_LockEye = deviceCode_LockEye;
	}
	

	public int getLockEyeID() {
		return lockEyeID;
	}


	public void setLockEyeID(int lockEyeID) {
		this.lockEyeID = lockEyeID;
	}


	public String getEyeLocation() {
		return eyeLocation;
	}


	public void setEyeLocation(String eyeLocation) {
		this.eyeLocation = eyeLocation;
	}


	public String getEyeLevel() {
		return eyeLevel;
	}


	public void setEyeLevel(String eyeLevel) {
		this.eyeLevel = eyeLevel;
	}


	public House getHouse_LockEye() {
		return house_LockEye;
	}


	public void setHouse_LockEye(House house_LockEye) {
		this.house_LockEye = house_LockEye;
	}


	public DeviceCode getDeviceCode_LockEye() {
		return deviceCode_LockEye;
	}

	
	public void setDeviceCode_LockEye(DeviceCode deviceCode_LockEye) {
		this.deviceCode_LockEye = deviceCode_LockEye;
	}


	public List<Video> getVideo() {
		return video;
	}


	public void setVideo(List<Video> video) {
		this.video = video;
	}


	public List<EyeNotification> getEyeNotification() {
		return eyeNotification;
	}


	public void setEyeNotification(List<EyeNotification> eyeNotification) {
		this.eyeNotification = eyeNotification;
	}
	
	
	@Override
	public void save(String level, String location, DeviceCode keyz, House houseID) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");  
	    Date date = new Date(); 
	    String df = formatter.format(date);  
	    long currentTimestamp = Long.parseLong(df);
	    
		LockEyeBean lockEyeBean = new LockEyeBean();
		int id = lockEyeBean.insertLockEye(new LockEye(level, location, keyz, houseID));
		
		LockEye lockEye = new LockEye();
		lockEye.setLockEyeID(id);
		
		VideoBean videoBean = new VideoBean();
		Video video = new Video(currentTimestamp, currentTimestamp, "1.MP4", 0.5, lockEye);
		videoBean.insertVideo(video);
	}


	@Override
	public String toString() {
		return "LockEye [lockEyeID=" + lockEyeID + ", eyeLocation=" + eyeLocation + ", eyeLevel=" + eyeLevel + "]";
	}
	
}