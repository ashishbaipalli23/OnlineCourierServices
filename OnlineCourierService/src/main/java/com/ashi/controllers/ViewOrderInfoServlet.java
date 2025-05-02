package com.ashi.controllers;

import java.io.IOException;

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
@WebServlet("/viewOrderInfo")
public class ViewOrderInfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		HttpSession httpSession = request.getSession();
		if(httpSession != null) {
			//get the orderID form[name]
			int orderId = Integer.parseInt(request.getParameter("orderId"));
			//get staff_id form session object 
			DeliveryAgentBean agent = (DeliveryAgentBean)httpSession.getAttribute("agentBean");
			int staffId = agent.getStaffId();
			
			//DAO
			OrderBean order = new OrdersDAO().getOrderDetailsToAgent(orderId, staffId);
			   if (order != null) {
		            request.setAttribute("orderDetails", order);
		        } else {
		            request.setAttribute("error", "Order details not found.");
		        }
		        
		        // Forward the request to the JSP for rendering
		        request.getRequestDispatcher("viewOrderDetails.jsp").forward(request, response);
			
		}
		else {
			 request.setAttribute("msg", "Session Expried Please Login Again");
			 request.getRequestDispatcher("sessionExpAgent.jsp").forward(request, response);
		}
		
		
	}
	
}



















