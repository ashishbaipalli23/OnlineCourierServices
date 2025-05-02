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

@WebServlet("/assignCourierToAgent")
public class AssignCourierToAgentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		if(httpSession != null) {
			//get the orderID/ and agentId to assign courier to the agent
			//select[name]
			int stafId = Integer.parseInt(request.getParameter("staffId"));
			//hidden filed
			int orderId = Integer.parseInt(request.getParameter("orderId"));
			int k1 = new DeliveryAgentDAO().OrderToStaff(orderId, stafId);
			int k2 = new OrdersDAO().assignStaffToOrder(orderId, stafId);
			if(k1 > 0 && k2 > 0) {
				//System.out.println("order assigned");
				//request data lost , again load it...
				 List<DeliveryAgentBean> agents = new DeliveryAgentDAO().getUnsignedAgents();
				 
				 
					//get the data from the order table(unasigned orders) and assign to avilable agents 
					////also get some details of the courier pickup/drop and other nessasy info 
					 List<OrderBean> unassingedOrders = new OrdersDAO().getUnassignedOrdersWithCourierDetails();
					 
					
					// Set these lists as request attributes to be accessed in JSP
			            request.setAttribute("agents", agents);
			            request.setAttribute("unassignedOrders", unassingedOrders );

				request.setAttribute("msg", "order assinged to "+stafId);
				
				
			}
			else {
				//System.out.println("error in assigned order");
				request.setAttribute("msg", "order assinged Order Faild");
			}
			
			
			
			
			request.getRequestDispatcher("assignCourier.jsp").forward(request, response);
		}
		else {
			  request.setAttribute("msg", "Session Expired. Please login again.");
	          request.getRequestDispatcher("sessionExpAdmin.jsp").forward(request, response); 
		}
	}

}
