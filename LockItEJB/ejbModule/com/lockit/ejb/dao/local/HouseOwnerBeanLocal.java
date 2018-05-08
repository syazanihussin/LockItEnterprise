package com.lockit.ejb.dao.local;


import java.util.List;
import javax.ejb.Local;
import com.lockit.entity.HouseOwner;


@Local
public interface HouseOwnerBeanLocal {

	void insertHouseOwner(HouseOwner houseOwner);
	HouseOwner getHouseOwnerById(int id);
	List<HouseOwner> getAllHouseOwners();
	void updateHouseOwner(HouseOwner houseOwner);
	void deleteHouseOwner(int id);
	void deleteAllHouseOwners();

}
