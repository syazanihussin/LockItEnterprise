package com.lockit.controller;


import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lockit.ejb.logic.local.LockEyeLogicLocal;
import com.lockit.ejb.logic.local.LockSenseLogicLocal;
import com.lockit.ejb.logic.local.NotificationLogicLocal;
import com.lockit.ejb.logic.local.VideoLogicLocal;


@WebServlet("/dashboardController")
public class dashboardController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
    @EJB
    LockEyeLogicLocal lockEyeLogicLocal;
    
    @EJB
    LockSenseLogicLocal lockSenseLogicLocal;
    NotificationLogicLocal notificationLogicLocal ;
	
    @EJB
    VideoLogicLocal videoLogicLocal;
    
    public dashboardController() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		request.getRequestDispatcher("dashboard/pages/homepage.jsp").forward(request, response);			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
