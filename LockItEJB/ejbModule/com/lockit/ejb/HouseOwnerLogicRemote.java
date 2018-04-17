package com.lockit.ejb;


import javax.ejb.Remote;
import com.lockit.entity.HouseOwner;


@Remote
public interface HouseOwnerLogicRemote {

	Boolean authenticateHouseOwner(String email, String password);
	HouseOwner getCurrentHouseOwner();
	void setCurrentHouseOwner(HouseOwner houseOwner);
	
}
