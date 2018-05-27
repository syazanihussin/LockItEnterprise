package com.lockit.ejb.logic.local;


import javax.ejb.Local;


@Local
public interface VideoLogicLocal {

	double calculateRemainingSpace();
	int calculateTotalVideo();	
	
}
