package com.ashi.controllers;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/paymentPage")
public class PaymentPageServlet extends HttpServlet{
	 @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		
		if(httpSession != null) {
			//get the courier object from the session object 
			//CourierBean cBean = (CourierBean)httpSession.getAttribute("courierBean");
			//request.setAttribute("courier", cBean);
			//access the session object directly in the JSP page
			//CustomerBean cBean2  = (CustomerBean)httpSession.getAttribute("customerBean");
			
		    request.getRequestDispatcher("paymentForm.jsp").forward(request, response);
			
			
		}
		else {
			    request.setAttribute("msg", "Session Expired. Please login again.");
	            request.getRequestDispatcher("sessionExp.jsp").forward(request, response);
		}
	}
	
}
