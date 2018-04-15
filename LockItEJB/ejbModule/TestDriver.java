import com.lockit.ejb.dao.HouseOwnerBean;
import com.lockit.entity.House;
import com.lockit.entity.HouseOwner;

public class TestDriver {

	public static void main(String[] args) {
		
		//INSERT
		HouseOwnerBean houseOwnerBean = new HouseOwnerBean();
		HouseOwner houseOwner = new HouseOwner("syazanihussin", "spectrum", "syazanihussin@gmail.com", "961225-10-5835", "017-3852095");
		House house = new House("Lot254 Kampung Katong", "C://image/house.png", houseOwner);
		houseOwner.setHouse(house);
		houseOwnerBean.insertHouseOwner(houseOwner);
		
		
		//UPDATE
		houseOwner.setEmail("sdhjdsbfdhfdf");
		houseOwnerBean.updateHouseOwner(houseOwner);
		
		
		//SELECT
		//HouseOwner houseOwner2 = houseOwnerBean.getHouseOwnerById(22);
		//System.out.println(houseOwner2.toString());
		
		
		//DELECT
		
		
	}

}
