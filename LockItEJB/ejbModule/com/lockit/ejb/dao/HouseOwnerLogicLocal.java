package com.lockit.ejb.dao;


import javax.ejb.Local;
import com.lockit.entity.HouseOwner;


@Local
public interface HouseOwnerLogicLocal {

	Boolean authenticateHouseOwner(String email, String password);
	HouseOwner getCurrentHouseOwner();
	void setCurrentHouseOwner(HouseOwner houseOwner);

}
