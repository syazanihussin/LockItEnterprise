package com.lockit.ejb.logic.remote;

import javax.ejb.Remote;

@Remote
public interface VideoBeanLogicRemote {
	
	int calculateRemainingSpace();

	int calculateTotalVideo();
	
}
