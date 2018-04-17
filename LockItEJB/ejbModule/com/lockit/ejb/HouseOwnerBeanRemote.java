package com.lockit.ejb;


import java.util.List;
import javax.ejb.Remote;
import com.lockit.entity.HouseOwner;


@Remote
public interface HouseOwnerBeanRemote {

	void insertHouseOwner(HouseOwner houseOwner);
	HouseOwner getHouseOwnerById(int id);
	List<HouseOwner> getAllHouseOwners();
	void updateHouseOwner(HouseOwner houseOwner);
	void deleteHouseOwner(int id);
	void deleteAllHouseOwners();
}
