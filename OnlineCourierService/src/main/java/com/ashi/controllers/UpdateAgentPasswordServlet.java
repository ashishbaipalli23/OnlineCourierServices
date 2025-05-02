package com.ashi.controllers;

import java.io.IOException;

import com.ashi.BeansandDAOs.DeliveryAgentBean;
import com.ashi.BeansandDAOs.DeliveryAgentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/updateAgentPassword")
public class UpdateAgentPasswordServlet extends HttpServlet {

		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			HttpSession httpSession = request.getSession(false);
			if(httpSession != null){
				//get the agentBean from the session object 
				
				DeliveryAgentBean agent = (DeliveryAgentBean)httpSession.getAttribute("agentBean");
				//get the data from the request object 
				
				String oldPassword = request.getParameter("oldPassword");
				String newPassword = request.getParameter("newPassword");
				
				if(agent.getPassword().equals(oldPassword)) {
				  //if old password is matched to exsting password 
				 //update the password with new password for the current staffId
					
					int k = new DeliveryAgentDAO().updatePassword(agent.getStaffId(), newPassword);
					if(k > 0) {
						request.setAttribute("msg", "Password updated!");
						request.getRequestDispatcher("agentProfile.jsp").forward(request, response);
					}
					else {
						request.setAttribute("msg", "Error in the agent Password updated!");
						request.getRequestDispatcher("errorPage.jsp").forward(request, response);
					}
				}
				else {
					request.setAttribute("msg", "invalid old password!");
					request.getRequestDispatcher("agentProfile.jsp").forward(request, response);
				}
			}
			else {
				  request.setAttribute("msg", "Session Expired. Please login again.");
		          request.getRequestDispatcher("sessionExpAgent.jsp").forward(request, response);
				
			}
		}
	
}
