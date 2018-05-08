package com.lockit.ejb;


import java.util.concurrent.TimeUnit;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import com.lockit.ejb.dao.local.EyeNotificationBeanLocal;
import com.lockit.ejb.dao.local.SenseNotificationBeanLocal;
import com.lockit.ejb.logic.local.NotificationLogicLocal;
import com.lockit.ejb.logic.remote.NotificationLogicRemote;


@Stateless
@LocalBean
public class NotificationBean implements NotificationLogicRemote, NotificationLogicLocal {
    
	
    public NotificationBean() {
        
    }
    
    
    @Override
	public int calculateTotalNotifications() {
    	EyeNotificationBeanLocal eyeNotificationLocal = new EyeNotificationBean(); 
    	SenseNotificationBeanLocal senseNotificationLocal = new SenseNotificationBean();
		return eyeNotificationLocal.getAllEyeNotifications().size() + senseNotificationLocal.getAllSenseNotifications().size();
	}
	
	
	@Override
	public String classifyNotificationUnit(long interval) {
			
		String word = "";
		
		if(interval <= 60000) {
			long intervalInSecond = TimeUnit.MILLISECONDS.toSeconds(interval);
			word = intervalInSecond + " seconds ago";
		}
			
		else if(interval > 60000 && interval <= 3600000) {
			long intervalInMinute = TimeUnit.MILLISECONDS.toMinutes(interval);
			word = intervalInMinute + " minutes ago";
		}
			
		else if(interval > 3600000 && interval <= 86400000) {
			long intervalInHour = TimeUnit.MILLISECONDS.toHours(interval);
			word = intervalInHour + " hours ago";
		}
			
		else if(interval > 86400000) {
			long intervalInDay = TimeUnit.MILLISECONDS.toDays(interval);
			word = intervalInDay + " days ago";
		}
		
		return word;
	}

}
