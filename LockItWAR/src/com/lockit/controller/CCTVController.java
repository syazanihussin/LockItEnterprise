package com.lockit.controller;


import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.lockit.ejb.dao.local.VideoBeanLocal;
import com.lockit.entity.Video;


@WebServlet("/CCTVController")
public class CCTVController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	VideoBeanLocal videoBeanLocal;
       
    
    public CCTVController() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true); 
		List<Video> video = videoBeanLocal.getAllVideos();
		session.setAttribute("videoList", video);
		response.sendRedirect("dashboard/pages/cctv.jsp");	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
