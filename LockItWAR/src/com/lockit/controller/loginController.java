package com.lockit.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lockit.ejb.dao.HouseOwnerBeanRemote;
import com.lockit.entity.HouseOwner;


@WebServlet("/loginController")
public class loginController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	HouseOwnerBeanRemote houseOwnerBeanRemote;
       
    
    public loginController() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//GET INPUT
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		 	
		System.out.println(email + " , " + password);
		
		EJBLookup ejbLookup = new EJBLookup(); 
		
		System.out.println(ejbLookup.getHouseOwnerLogicRemote().authenticateHouseOwner(email, password));
		if(ejbLookup.getHouseOwnerLogicRemote().authenticateHouseOwner(email, password) == true) {
			System.out.println(ejbLookup.getHouseOwnerLogicRemote().getCurrentHouseOwner().getPhoneNumber());
		}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
