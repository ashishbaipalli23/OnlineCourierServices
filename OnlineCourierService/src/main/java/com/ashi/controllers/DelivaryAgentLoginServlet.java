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
@WebServlet("/deliveryAgentLogin")
public class DelivaryAgentLoginServlet extends HttpServlet{
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//get the data from the form[name]
			    String userid = request.getParameter("userID").trim();
			    String password = request.getParameter("password").trim();
			    
			    DeliveryAgentBean agentBean = new DeliveryAgentDAO().login(userid, password);
			    
			    if(agentBean != null) {
			    	
			    	HttpSession httpSession = request.getSession();
			    	httpSession.setAttribute("agentBean", agentBean);
			    	
			    	request.getRequestDispatcher("agentDashBoard.jsp").forward(request, response);
			    
			    }
			    else {	    	  
			    	request.setAttribute("msg", "invalid credentials!");
			    	request.getRequestDispatcher("deliveryAgentLogin.jsp").forward(request, response);			        
			    }
			
		}
}
