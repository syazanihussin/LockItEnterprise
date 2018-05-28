package com.lockit.controller;


import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lockit.ejb.dao.local.HouseOwnerBeanLocal;
import com.lockit.ejb.logic.local.HouseOwnerLogicLocal;
import com.lockit.entity.House;
import com.lockit.entity.HouseOwner;


@WebServlet("/houseOwnerController")
public class houseOwnerController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
    @EJB
    HouseOwnerBeanLocal houseOwnerBean;
    
    @EJB
    HouseOwnerLogicLocal houseOwnerLogic;
    
    
    public houseOwnerController() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//GET INPUT
		String ic = request.getParameter("ic");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		
		//INSERT
		HouseOwner houseOwner = new HouseOwner(userName, password, email, ic, phoneNumber);
		House house = new House("Lot254 Kampung Katong", "C://image/house.png", houseOwner);
		houseOwner.setHouse(house);
		
		houseOwnerBean.insertHouseOwner(houseOwner); 	
		
		houseOwnerLogic.setCurrentHouseOwner(houseOwner);
		String user = houseOwnerLogic.getCurrentHouseOwner().getUserName();
		response.setContentType("text/html");
		request.setAttribute("userName", user);
		request.getRequestDispatcher("dashboard/pages/homepage.jsp").forward(request, response);
		
	
		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		//out.println("<h3>User Information</h3>");
		//out.println("Result:" + house.getAddress());	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
