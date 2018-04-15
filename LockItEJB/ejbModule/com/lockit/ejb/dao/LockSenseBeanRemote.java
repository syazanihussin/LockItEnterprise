package com.lockit.ejb.dao;


import java.util.List;
import javax.ejb.Remote;
import com.lockit.entity.LockSense;


@Remote
public interface LockSenseBeanRemote {

	void insertLockSense(LockSense lockSense);
	LockSense getLockSenseById(int id);
	List<LockSense> getAllLockSenses();
	void updateLockSense(LockSense lockSense);
	void deleteLockSense(int id);
	void deleteAllLockSenses();

}
