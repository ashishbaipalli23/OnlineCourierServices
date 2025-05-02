package com.ashi.controllers;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/editOrder")
public class EditOrderServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  HttpSession httpSession = request.getSession(false);
	  if(httpSession != null) {
		    //URL rewriting : Request object have  (orderId (int))

			//int orderId = Integer.parseInt(request.getParameter("orderId"));
			//PK OrderId -> get the object from the 
			//get the data from the seesion (courier object)
			
			//CourierBean courierBean =(CourierBean) httpSession.getAttribute("courierBean");
		
			request.getRequestDispatcher("editOrder.jsp").forward(request, response);
			
	  }
	  else {
		  request.setAttribute("msg", "Session Expired. Please login again.");
          request.getRequestDispatcher("sessionExp.jsp").forward(request, response);
	  }
	}

}
