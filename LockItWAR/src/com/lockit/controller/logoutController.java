package com.lockit.controller;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.lockit.ejb.dao.remote.HouseOwnerBeanRemote;
import com.lockit.entity.HouseOwner;


@WebServlet("/logoutController")
public class logoutController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	HouseOwnerBeanRemote houseOwnerBeanRemote;
       
    
    public logoutController() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session != null) {
		    session.invalidate();
		}
		
		EJBLookup ejbLookup = new EJBLookup(); 
		System.out.println(ejbLookup.getHouseOwnerLogicRemote().getCurrentHouseOwner().getEmail());
		
		HouseOwner houseOwner = null;
		ejbLookup.getHouseOwnerLogicRemote().setCurrentHouseOwner(houseOwner);
		//System.out.println(ejbLookup.getHouseOwnerLogicRemote().getCurrentHouseOwner().getEmail());
		
		response.setContentType("text/html");
		RequestDispatcher rd = request.getRequestDispatcher("../../index.jsp");
		
		//rd.forward(request, response);
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
