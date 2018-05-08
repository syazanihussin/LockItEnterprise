import com.lockit.ejb.EyeNotificationBean;
import com.lockit.ejb.HouseOwnerBean;
import com.lockit.ejb.NotificationBean;
import com.lockit.ejb.SenseNotificationBean;
import com.lockit.ejb.dao.local.EyeNotificationBeanLocal;
import com.lockit.ejb.dao.local.SenseNotificationBeanLocal;
import com.lockit.ejb.logic.local.EyeNotificationLogicLocal;
import com.lockit.ejb.logic.local.NotificationLogicLocal;
import com.lockit.ejb.logic.local.SenseNotificationLogicLocal;
import com.lockit.entity.EyeNotification;
import com.lockit.entity.House;
import com.lockit.entity.HouseOwner;
import com.lockit.entity.SenseNotification;

public class TestDriver {

	public static void main(String[] args) {
				  
		
		//INSERT
		HouseOwnerBean houseOwnerBean = new HouseOwnerBean();
		HouseOwner houseOwner = new HouseOwner("syazanihussin", "spectrum", "syazanihussin@gmail.com", "961225-10-5835", "017-3852095");
		House house = new House("Lot254 Kampung Katong", "C://image/house.png", houseOwner);
		houseOwner.setHouse(house);
		houseOwnerBean.insertHouseOwner(houseOwner);
		
		
		//UPDATE
		houseOwner.setEmail("syazani00@gmail.com");
		houseOwnerBean.updateHouseOwner(houseOwner);
		
		
		//SELECT
		HouseOwner houseOwner2 = houseOwnerBean.getHouseOwnerById(39);
		System.out.println(houseOwner2.toString());
		System.out.println(houseOwner2.getEmail());
		
		
		//SELECT ALL HOUSES
		for(HouseOwner houseOwner3 : houseOwnerBean.getAllHouseOwners()) {
			System.out.println(houseOwner3.getEmail());
		}
		
		
		//DELECT
		
		
		//DELECT ALL HOUSES
		
		
		//NOTIFICATION
		NotificationLogicLocal notificationLogicLocal = new NotificationBean();
		EyeNotificationBeanLocal eyeNotificationBeanLocal = new EyeNotificationBean();
		EyeNotificationLogicLocal eyeNotificationLogicLocal = new EyeNotificationBean();
		SenseNotificationBeanLocal senseNotificationBeanLocal = new SenseNotificationBean();
		SenseNotificationLogicLocal senseNotificationLogicLocal = new SenseNotificationBean();
		
		System.out.println(notificationLogicLocal.calculateTotalNotifications());
		
		for(EyeNotification eye : eyeNotificationBeanLocal.getAllEyeNotifications()) {
			System.out.println(eyeNotificationLogicLocal.getEyeNotificationInterval(eye));
		}
		
		for(SenseNotification sense : senseNotificationBeanLocal.getAllSenseNotifications()) {
			System.out.println(senseNotificationLogicLocal.getSenseNotificationInterval(sense));
		}
		
	}

}
