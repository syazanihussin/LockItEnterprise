package com.lockit.ejb.dao;


import java.util.List;
import javax.ejb.Local;
import com.lockit.entity.LockSense;


@Local
public interface LockSenseBeanLocal {

	void insertLockSense(LockSense lockSense);
	LockSense getLockSenseById(int id);
	List<LockSense> getAllLockSenses();
	void updateLockSense(LockSense lockSense);
	void deleteLockSense(int id);
	void deleteAllLockSenses();

}
