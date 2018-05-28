package com.lockit.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lockit.ejb.dao.local.SenseNotificationBeanLocal;
import com.lockit.ejb.logic.local.SenseNotificationLogicLocal;
import com.lockit.ejb.logic.local.SensorDataLogicLocal;
import com.lockit.entity.HouseOwner;
import com.lockit.entity.LockEye;
import com.lockit.entity.LockSense;
import com.lockit.entity.SenseNotification;
import com.lockit.entity.SensorData;

@WebServlet("/NotifyController")
public class NotifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	SenseNotificationBeanLocal senseNotificationBeanLocal;
	
	@EJB
	SenseNotificationLogicLocal senseNotificationLogicLocal;
	
	@EJB
	SensorDataLogicLocal senseDataLogicLocal;
	
	
	
   
    public NotifyController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<SenseNotification> senseNotificationList = new ArrayList<>();
		List<String> intervalList = new ArrayList<>();
		
		for(SenseNotification senseNotification : senseNotificationBeanLocal.getAllSenseNotifications()) {
			senseNotificationList.add(senseNotification);
			intervalList.add(senseNotificationLogicLocal.getSenseNotificationInterval(senseNotification));
		}
		
		request.setAttribute("noti", senseNotificationList);
		request.setAttribute("intervals", intervalList);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
