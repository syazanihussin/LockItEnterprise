
import com.lockit.ejb.dao.HouseBean;
import com.lockit.entity.House;
import com.lockit.entity.HouseOwner;

public class TestDriver {

	public static void main(String[] args) {
		
		
		HouseBean salesDao = new HouseBean();
		
		HouseOwner houseOwner = new HouseOwner("syazanihussin", "spectrum", "syazanihussin@gmail.com", "961225-10-5835", "017-3852095");
		
		House sales = new House("Lot254 Kampung Katong", "C://image/house.png", houseOwner);
		
		System.out.println(sales.getHouseOwner_House().getPassword());
		salesDao.insertHouse(sales);
	}

}
