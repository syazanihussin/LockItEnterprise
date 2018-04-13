package com.lockit.ejb;


import java.util.List;
import javax.ejb.Remote;
import com.lockit.entity.House;


@Remote
public interface HouseBeanRemote {
	
	void addHouse(House house);
	House getHouseById(int id);
	void deleteHouse(int id);
	void updateHouse(House house);
	List<House> getAllHouses();

}
