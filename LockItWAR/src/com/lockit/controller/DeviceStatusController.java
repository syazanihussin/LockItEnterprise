package com.lockit.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lockit.ejb.dao.local.LockEyeBeanLocal;
import com.lockit.ejb.dao.local.LockSenseBeanLocal;
import com.lockit.ejb.logic.local.LockEyeLogicLocal;
import com.lockit.ejb.logic.local.LockSenseLogicLocal;
import com.lockit.entity.LockEye;
import com.lockit.entity.LockSense;
import com.lockit.entity.SensorData;
import com.lockit.entity.Video;


@WebServlet("/DeviceStatusController")
public class DeviceStatusController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	LockSenseLogicLocal lockSenseLogicLocal;
	
	
	@EJB
	LockSenseBeanLocal lockSenseBeanLocal;
	
	
	@EJB
	LockEyeLogicLocal lockEyeLogicLocal;
	
	
	@EJB
	LockEyeBeanLocal lockEyeBeanLocal;
       
    
    public DeviceStatusController() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HashMap<SensorData, LockSense> dangerLockSenseList = lockSenseLogicLocal.checkLockSenseStatus();
		List<LockSense> allLockSense = lockSenseBeanLocal.getAllLockSenses();
		List<LockSense> dangerLockSenseList2 = new ArrayList<>();
		
		for(@SuppressWarnings("rawtypes") Map.Entry m : dangerLockSenseList.entrySet()) {
			
			LockSense dangerLockSense = (LockSense) m.getValue();
			dangerLockSenseList2.add(dangerLockSense);
			
			for(LockSense lockSense : allLockSense){  
				if(dangerLockSense.getLocksenseID() == lockSense.getLocksenseID()) {
					allLockSense.remove(lockSense);
				}
			}
		}
		
		
		/*HashMap<Video, LockEye> dangerLockEyeList = lockEyeLogicLocal.checkLockEyeStatus();
		List<LockEye> allLockEye = lockEyeBeanLocal.getAllLockEyes();
		List<LockEye> dangerLockEyeList2 = new ArrayList<>();
		
		for(@SuppressWarnings("rawtypes") Map.Entry m : dangerLockEyeList.entrySet()) {
			
			LockEye dangerLockEye = (LockEye) m.getValue();
			dangerLockEyeList2.add(dangerLockEye);
			
			for(LockEye lockEye : allLockEye){  
				if(dangerLockEye.getLockEyeID() == lockEye.getLockEyeID()) {
					allLockEye.remove(lockEye);
				}
			}
		}*/
		
		HttpSession session = request.getSession(true); 
		session.setAttribute("dangerLockSense", dangerLockSenseList2);
		session.setAttribute("normalLockSense", allLockSense);
		//session.setAttribute("dangerLockEye", dangerLockEyeList2);
		//session.setAttribute("normalLockEye", allLockEye);
		response.sendRedirect("dashboard/pages/device.jsp");	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
