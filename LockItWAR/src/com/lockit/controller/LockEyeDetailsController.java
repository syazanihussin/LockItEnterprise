package com.lockit.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lockit.ejb.dao.local.LockEyeBeanLocal;
import com.lockit.entity.LockEye;
import com.lockit.entity.SensorData;

/**
 * Servlet implementation class LockEyeDetails
 */
@WebServlet("/LockEyeDetailsController")
public class LockEyeDetailsController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	LockEyeBeanLocal lockEyeBeanLocal;
    
    public LockEyeDetailsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		LockEye le =  lockEyeBeanLocal.getLockEyeById(id);
		
		response.setContentType("text/html");
		request.setAttribute("lockEye", le);
		request.getRequestDispatcher("dashboard/pages/activity2.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
