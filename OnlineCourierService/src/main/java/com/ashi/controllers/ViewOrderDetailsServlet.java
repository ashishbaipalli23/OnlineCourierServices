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
@WebServlet("/viewOrderDetails")
public class ViewOrderDetailsServlet extends HttpServlet{
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//check the session
		HttpSession httpSession = request.getSession(false);
		if(httpSession != null) {
			//get the Id from the request object URL rewriting 
			int orderId = Integer.parseInt(request.getParameter("id"));
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






















