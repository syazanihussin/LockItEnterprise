package com.lockit.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lockit.ejb.dao.HouseOwnerBean;
import com.lockit.entity.House;
import com.lockit.entity.HouseOwner;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet(name = "registerServlet", urlPatterns = {"/registerServlet"})
public class registerServlet extends HttpServlet {
   
	@EJB
	private HouseOwnerBean houseOwnerBean;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String submitRegister = request.getParameter("submitRegister");
		
		String ic = request.getParameter("ic");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		HouseOwnerBean houseOwnerBean = new HouseOwnerBean();
		HouseOwner houseOwner = new HouseOwner(userName, password, email, ic, phoneNumber);
		House house = new House(address, "C://image/house.png", houseOwner);
		
		if ("REGISTER".equalsIgnoreCase(submitRegister)) {
			houseOwner.setHouse(house);
			houseOwnerBean.insertHouseOwner(houseOwner);
		}
		request.getRequestDispatcher("index.jsp")
		
	}

	
}
