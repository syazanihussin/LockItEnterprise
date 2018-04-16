package com.lockit.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lockit.ejb.dao.HouseOwnerBeanRemote;
import com.lockit.entity.House;
import com.lockit.entity.HouseOwner;


@WebServlet("/houseOwnerController")
public class houseOwnerController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	HouseOwnerBeanRemote houseOwnerBeanRemote;
       
    
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
		doBeanLookup().insertHouseOwner(houseOwner); 	
		
		//UPDATE
		houseOwner.setEmail("syazani00@gmail.com");
		doBeanLookup().updateHouseOwner(houseOwner);
				
				
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3>User Information</h3>");
		out.println("Result:" + house.getAddress());	
		
		
		//SELECT
		HouseOwner houseOwner2 = doBeanLookup().getHouseOwnerById(39);
		out.println(houseOwner2.toString());
		out.println(houseOwner2.getEmail());
				
				
		//SELECT ALL HOUSES
		for(HouseOwner houseOwner3 : doBeanLookup().getAllHouseOwners()) {
			out.println(houseOwner3.getEmail());
		}
		
		
		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		//out.println("<h3>User Information</h3>");
		//out.println("Result:" + house.getAddress());	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	public HouseOwnerBeanRemote doBeanLookup() {
		Properties prop = new Properties();
	    prop.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
	    prop.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
	    prop.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
	    
	    try {
	        InitialContext ctx = new InitialContext(prop);                              
	        houseOwnerBeanRemote = (HouseOwnerBeanRemote) ctx.lookup("java:global/LockItEAR/LockItWAR/HouseOwnerBean!com.lockit.ejb.dao.HouseOwnerBeanRemote");
	        System.out.println("EJB Look-up successfull. yeahhh");
	    } catch (NamingException e) {
	        e.printStackTrace();
	    }
	    
	    return houseOwnerBeanRemote;
	}

}
