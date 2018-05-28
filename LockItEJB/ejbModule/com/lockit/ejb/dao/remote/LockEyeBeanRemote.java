package com.lockit.ejb.dao.remote;


import java.util.List;
import javax.ejb.Remote;
import com.lockit.entity.LockEye;


@Remote
public interface LockEyeBeanRemote {

	int insertLockEye(LockEye lockEye);
	LockEye getLockEyeById(int id);
	List<LockEye> getAllLockEyes();
	void updateLockEye(LockEye lockEye);
	void deleteLockEye(int id);
	void deleteAllLockEyes();
	
}
