package com.lockit.ejb;


import java.util.List;
import javax.ejb.Remote;
import com.lockit.entity.House;


@Remote
public interface HouseBeanRemote {
	
	void insertHouse(House house);
	House getHouseById(int id);
	List<House> getAllHouses();
	void updateHouse(House house);
	void deleteHouse(int id);
	void deleteAllHouses();

}
