package com.lockit.ejb.dao.local;


import java.util.List;
import javax.ejb.Local;
import com.lockit.entity.House;


@Local
public interface HouseBeanLocal {

	void insertHouse(House house);
	House getHouseById(int id);
	List<House> getAllHouses();
	void updateHouse(House house);
	void deleteHouse(int id);
	void deleteAllHouses();

}
