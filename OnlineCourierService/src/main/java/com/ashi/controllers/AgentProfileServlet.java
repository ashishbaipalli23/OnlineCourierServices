package com.ashi.controllers;

import java.io.IOException;
import com.ashi.BeansandDAOs.DeliveryAgentBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/agentProfile")
public class AgentProfileServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hSession = request.getSession(false);
		if(hSession != null) {
			
			//get the data from the session object 
			DeliveryAgentBean agent = (DeliveryAgentBean)hSession.getAttribute("agentBean");
			  
            // Get the agent's photo (InputStream)
            
            //InputStream agentPhotoStream = new DeliveryAgentDAO().getAgentPhotoById(agent.getStaffId());
            
            // Add agent and photo to the request object
			// this is optional
            request.setAttribute("agentBean", agent);
           // request.setAttribute("agentPhotoStream", agentPhotoStream);
            
            // Forward to the agentProfile.jsp page
            request.getRequestDispatcher("agentProfile.jsp").forward(request, response);
			
			
		}
		else {
			  request.setAttribute("msg", "Session Expired. Please login again.");
	          request.getRequestDispatcher("sessionExpAgent.jsp").forward(request, response);
			
		}
		
	}
}





























