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
@WebServlet("/updateStatus")
public class UpdateOrderStatusServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession httpSession = request.getSession(false);
		 if(httpSession != null) {
			 //get the staffId
			 DeliveryAgentBean agent = (DeliveryAgentBean)httpSession.getAttribute("agentBean");
			 int staffId = agent.getStaffId();
			 
			 //get the assigned orders which are not delivered/status !=delivivered 
			 OrderBean order = new OrdersDAO().getAssignedOrderForAgent(staffId);
			
			 if (order != null) {
		            request.setAttribute("assignedOrder", order);
		            request.getRequestDispatcher("updateStatus.jsp").forward(request, response);
		        } else {
		            request.setAttribute("msg", "❌ No active order assigned to you.");
		            request.getRequestDispatcher("updateStatus.jsp").forward(request, response);
		        }
			 
			 
			
			 
		 }
		 else {
			 request.setAttribute("msg", "Session Expried Please Login Again");
			 request.getRequestDispatcher("sessionExpAgent.jsp").forward(request, response);
		 }
	}

	
	//this is called when you click on the update status
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hSession = request.getSession(false);
		if(hSession != null) {
			//get the data from the updateStatus.jsp form[name]
			int orderId = Integer.parseInt(request.getParameter("orderId"));
			String status = request.getParameter("status");
			//get the agentId from the session object 
			DeliveryAgentBean agent = (DeliveryAgentBean)hSession.getAttribute("agentBean");
			int staffId = agent.getStaffId();
			
			//DAO logic 
			OrdersDAO dao = new OrdersDAO();
            String result = dao.updateOrderStatus(orderId, staffId, status);

            if ("success".equals(result)) {
                request.setAttribute("msg", "Order status updated successfully.");
            } else if ("Order not found or unauthorized update attempt.".equals(result)) {
                request.setAttribute("msg", result);
            } else {
                request.setAttribute("msg", "Something went wrong. Please try again.");
            }
            
            request.getRequestDispatcher("updateStatus.jsp").forward(request, response);
			
		}
		else {
			 request.setAttribute("msg", "Session Expried Please Login Again");
			 request.getRequestDispatcher("sessionExpAgent.jsp").forward(request, response);
		}
				
	}
	
	
	
	
}















