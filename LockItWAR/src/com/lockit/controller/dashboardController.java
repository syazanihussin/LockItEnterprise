package com.lockit.controller;


import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lockit.ejb.logic.local.NotificationLogicLocal;
import com.lockit.ejb.logic.local.VideoLogicLocal;


@WebServlet("/dashboardController")
public class dashboardController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
    @EJB
    NotificationLogicLocal notificationLogicLocal ;
	
    @EJB
    VideoLogicLocal videoLogicLocal;
    
    public dashboardController() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int total = notificationLogicLocal.calculateTotalNotifications();
		request.setAttribute("totalNotification", total);
		
		double remain = videoLogicLocal.calculateRemainingSpace();
		request.setAttribute("remainingSpace", remain);
		
		response.setContentType("text/html");
		request.getRequestDispatcher("dashboardController").forward(request, response);			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
