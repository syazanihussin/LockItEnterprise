package com.lockit.ejb.logic.remote;


import javax.ejb.Remote;


@Remote
public interface VideoLogicRemote {
	
	double calculateRemainingSpace();
	int calculateTotalVideo();
	
}
