package com.lockit.controller;


import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lockit.ejb.logic.local.DeviceCodeLogicLocal;
import com.lockit.entity.DeviceCode;
import com.lockit.entity.House;
import com.lockit.factory.LockItDeviceFactory;


@WebServlet("/registerDeviceController")
public class registerDeviceController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	DeviceCodeLogicLocal deviceCodeLogicLocal;
	LockItDeviceFactory lockItDeviceFactory = new LockItDeviceFactory(); 
       
   
    public registerDeviceController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//GET INPUT
		String deviceCode = request.getParameter("deviceCode");
		String location = request.getParameter("location");
		String level = request.getParameter("level");
		
		register(deviceCode, location, level);
		response.setContentType("text/html");
		request.getRequestDispatcher("registerController").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	protected void register(String deviceCode, String location, String level) {
		String deviceName = deviceCodeLogicLocal.determineDeviceType(deviceCode);
		
		House house = new House();
		house.setHouseID(1);
		
		DeviceCode deviceCodeO = new DeviceCode();
		deviceCodeO.setKeyz(deviceCode);
		
		lockItDeviceFactory.getLockItDevice(deviceName).save(level, location, deviceCodeO, house);
		
	}

}
