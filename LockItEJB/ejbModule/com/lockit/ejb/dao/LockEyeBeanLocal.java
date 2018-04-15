package com.lockit.ejb.dao;


import java.util.List;
import javax.ejb.Local;
import com.lockit.entity.LockEye;


@Local
public interface LockEyeBeanLocal {

	void insertLockEye(LockEye lockEye);
	LockEye getLockEyeById(int id);
	List<LockEye> getAllLockEyes();
	void updateLockEye(LockEye lockEye);
	void deleteLockEye(int id);
	void deleteAllLockEyes();

}
