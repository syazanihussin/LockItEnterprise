package com.lockit.ejb.logic.remote;


import java.util.HashMap;
import javax.ejb.Remote;
import com.lockit.entity.LockEye;
import com.lockit.entity.Video;


@Remote
public interface LockEyeLogicRemote {

	HashMap<Video, LockEye> checkLockEyeStatus();
	int calculateTotalLockEye();
	
}
