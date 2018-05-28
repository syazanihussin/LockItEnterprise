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

		HttpSession session = request.getSession(true); 
		checkingLockSense(session);
		checkingLockEye(session);
		response.sendRedirect("dashboard/pages/device.jsp");	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	public void checkingLockSense(HttpSession session) {
		
		List<LockSense> normalLockSense = new ArrayList<>();
		List<LockSense> dangerLockSense = new ArrayList<>();
		
		for(LockSense lockSense : lockSenseBeanLocal.getAllLockSenses()){  
			HashMap<SensorData, LockSense> a = lockSenseLogicLocal.checkLockSenseStatus(lockSense.getLocksenseID());
			
			if(a.isEmpty()) {
				normalLockSense.add(lockSense);
			} else {
				for(@SuppressWarnings("rawtypes") Map.Entry m : a.entrySet()) {
					dangerLockSense.add((LockSense) m.getValue());
				}
			}
		}
		
		session.setAttribute("dangerLockSense", dangerLockSense);
		session.setAttribute("normalLockSense", normalLockSense);
	}
	
	
	public void checkingLockEye(HttpSession session) {
		
	    List<LockEye> normalLockEye = new ArrayList<>();
		List<LockEye> dangerLockEye = new ArrayList<>();
		
		for(LockEye lockEye : lockEyeBeanLocal.getAllLockEyes()){  
			HashMap<Video, LockEye> a = lockEyeLogicLocal.checkLockEyeStatus(lockEye.getLockEyeID());
			
			if(a.isEmpty()) {
				normalLockEye.add(lockEye);
			} else {
				for(@SuppressWarnings("rawtypes") Map.Entry m : a.entrySet()) {
					dangerLockEye.add((LockEye) m.getValue());
				}
			}
		}
		
		session.setAttribute("dangerLockEye", dangerLockEye);
		session.setAttribute("normalLockEye", normalLockEye);
	}

}
