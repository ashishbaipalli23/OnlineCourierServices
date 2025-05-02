package com.ashi.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.ashi.BeansandDAOs.DeliveryAgentBean;
import com.ashi.BeansandDAOs.DeliveryAgentDAO;
import com.ashi.BeansandDAOs.OrderBean;
import com.ashi.BeansandDAOs.OrdersDAO;


@SuppressWarnings("serial")
@WebServlet("/assignCourier")
public class AssignCourierServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		 HttpSession httpSession = request.getSession(false);
		 if(httpSession != null) {
			//check the avilability of the deliveryagents(get all delivery agents)
			 
			 List<DeliveryAgentBean> agents = new DeliveryAgentDAO().getUnsignedAgents();
			 
			 
			//get the data from the order table(unasigned orders) and assign to avilable agents 
			////also get some details of the courier pickup/drop and other nessasy info 
			 List<OrderBean> unassingedOrders = new OrdersDAO().getUnassignedOrdersWithCourierDetails();
			 
			
			// Set these lists as request attributes to be accessed in JSP
	            request.setAttribute("agents", agents);
	            request.setAttribute("unassignedOrders", unassingedOrders );

	            // Forward to the JSP page where the admin can assign orders
	            request.getRequestDispatcher("assignCourier.jsp").forward(request, response);
			 
			
			 
			
			 
		 }
		 else {
			  request.setAttribute("msg", "Session Expired. Please login again.");
	          request.getRequestDispatcher("sessionExpAdmin.jsp").forward(request, response); 
		 }
	}
	



}
