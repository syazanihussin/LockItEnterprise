package com.lockit.controller;


import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lockit.ejb.logic.local.HouseOwnerLogicLocal;
import com.lockit.entity.HouseOwner;


@WebServlet("/logoutController")
public class logoutController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	HouseOwnerLogicLocal houseOwnerLogicLocal;
       
    
    public logoutController() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.removeAttribute("userName");
		
		HouseOwner houseOwner = null;
		houseOwnerLogicLocal.setCurrentHouseOwner(houseOwner);
		
		response.setContentType("text/html");
		response.sendRedirect("index.jsp");
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
