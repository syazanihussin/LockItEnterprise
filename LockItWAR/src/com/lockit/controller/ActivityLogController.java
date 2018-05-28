package com.lockit.controller;


import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.lockit.ejb.dao.local.DeviceInfoBeanLocal;
import com.lockit.ejb.dao.local.LockSenseBeanLocal;
import com.lockit.entity.DeviceInfo;
import com.lockit.entity.LockSense;
import com.lockit.entity.SensorData;


@WebServlet("/ActivityLogController")
public class ActivityLogController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
     
	@EJB
	LockSenseBeanLocal lockSenseBeanLocal;
	
	
	
    public ActivityLogController() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		LockSense ls = lockSenseBeanLocal.getLockSenseById(id);
		
		List <SensorData> sdList = ls.getSensorData();
		
		request.setAttribute("SensorData", sdList);
		request.getRequestDispatcher("dashboard/pages/activity.jsp").forward(request, response);;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
