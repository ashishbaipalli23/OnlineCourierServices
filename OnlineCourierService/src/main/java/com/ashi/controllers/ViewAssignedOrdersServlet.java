package com.ashi.controllers;

import java.io.IOException;
import java.util.List;

import com.ashi.BeansandDAOs.DeliveryAgentBean;
import com.ashi.BeansandDAOs.OrderBean;
import com.ashi.BeansandDAOs.OrdersDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/viewAssignedOrders")
public class ViewAssignedOrdersServlet  extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 HttpSession httpSession = request.getSession(false);
		 if(httpSession != null) {
			  
			 //get the agentBean form the session object 
			 DeliveryAgentBean agent = (DeliveryAgentBean)httpSession.getAttribute("agentBean");
			 
			 int staffId = agent.getStaffId();
			 
			 //get the assigned order details for a agent (undelivery orders only)
			 List<OrderBean> assignedOrders = new OrdersDAO().getOrdersByStaffId(staffId);
			 request.setAttribute("assignedOrders", assignedOrders);
	         request.getRequestDispatcher("assignedOrdersAgent.jsp").forward(request, response);
		 }
		 else {
			 request.setAttribute("msg", "Session Expried Please Login Again");
			 request.getRequestDispatcher("sessionExpAgent.jsp").forward(request, response);
		 }
		
	}
	
}


















