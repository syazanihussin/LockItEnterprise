package com.lockit.ejb.logic.local;

import javax.ejb.Local;


@Local
public interface VideoBeanLogicLocal {

	int calculateRemainingSpace();

	int calculateTotalVideo();	
	
}
