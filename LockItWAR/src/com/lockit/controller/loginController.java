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
		 	
		EJBLookup ejbLookup = new EJBLookup(); 
		
		if(ejbLookup.getHouseOwnerLogicRemote().authenticateHouseOwner(email, password) == true) {
			HttpSession session = request.getSession(true); 
			String user = ejbLookup.getHouseOwnerLogicRemote().getCurrentHouseOwner().getUserName();
			session.setAttribute("userName", user);
			response.sendRedirect("dashboard/pages/homepage.jsp");
		}
		
		else {
			response.setContentType("text/html");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
