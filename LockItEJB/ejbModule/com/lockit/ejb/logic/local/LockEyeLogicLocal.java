package com.lockit.ejb.logic.local;


import java.util.HashMap;
import javax.ejb.Local;
import com.lockit.entity.LockEye;
import com.lockit.entity.Video;


@Local
public interface LockEyeLogicLocal {

	HashMap<Video, LockEye> checkLockEyeStatus(int id);
	int calculateTotalLockEye();

}
