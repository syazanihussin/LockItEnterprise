package com.lockit.ejb;


import java.util.List;
import javax.ejb.Local;
import com.lockit.entity.House;


@Local
public interface HouseBeanLocal {

	void addHouse(House house);
	House getHouseById(int id);
	void deleteHouse(int id);
	void updateHouse(House house);
	List<House> getAllHouses();

}
