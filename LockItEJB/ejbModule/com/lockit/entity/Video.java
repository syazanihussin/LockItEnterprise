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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Video")
public class Video implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="videoID", unique = true)
	private int videoID;
	
	@Column(name="startRecordingTime")
	private int startRecordingTime;
	
	@Column(name="endRecordingTime")
	private int endRecordingTime ;
	
	@Column(name="videoClip")
	private String videoClip ;
	
	@Column(name="videoSize")
	private double videoSize ;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "videoID", nullable = false)
    LockEye lockEye_Video;//fkey
	
	
	
public Video() {
	super();
		

	
	
 }


public int getVideoID() {
	return videoID;
}



public void setVideoID(int videoID) {
	this.videoID = videoID;
}



public int getStartRecordingTime() {
	return startRecordingTime;
}



public void setStartRecordingTime(int startRecordingTime) {
	this.startRecordingTime = startRecordingTime;
}



public int getEndRecordingTime() {
	return endRecordingTime;
}



public void setEndRecordingTime(int endRecordingTime) {
	this.endRecordingTime = endRecordingTime;
}



public String getVideoClip() {
	return videoClip;
}



public void setVideoClip(String videoClip) {
	this.videoClip = videoClip;
}



public double getVideoSize() {
	return videoSize;
}



public void setVideoSize(double videoSize) {
	this.videoSize = videoSize;
}



public LockEye getLockEye_Video() {
	return lockEye_Video;
}



public void setLockEye_Video(LockEye lockEye_Video) {
	this.lockEye_Video = lockEye_Video;
}

@Override
public String toString() {
	return "Video [videoID=" + videoID + ", startRecordingTime=" + startRecordingTime + ", endRecordingTime="
			+ endRecordingTime + ", videoClip=" + videoClip + ", videoSize=" + videoSize + ", lockEye_Video="
			+ lockEye_Video + "]";
}


public Video(int startRecordingTime, int endRecordingTime, String videoClip, double videoSize, LockEye lockEye_Video) {
	super();
	this.startRecordingTime = startRecordingTime;
	this.endRecordingTime = endRecordingTime;
	this.videoClip = videoClip;
	this.videoSize = videoSize;
	this.lockEye_Video = lockEye_Video;
}


public Video(int startRecordingTime, int endRecordingTime, String videoClip, double videoSize) {
	super();
	this.startRecordingTime = startRecordingTime;
	this.endRecordingTime = endRecordingTime;
	this.videoClip = videoClip;
	this.videoSize = videoSize;
}

}
