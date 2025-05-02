package com.ashi.controllers;

import java.io.IOException;
import java.util.List;

import com.ashi.BeansandDAOs.DeliveryAgentBean;
import com.ashi.BeansandDAOs.DeliveryAgentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/manageStaff")
public class ManageStaffServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		HttpSession hSession = request.getSession(false);
		if(hSession != null) {
			
			//get the data from the agents 
			List<DeliveryAgentBean> agents = new DeliveryAgentDAO().getAgents();
			request.setAttribute("agents", agents);
	        request.getRequestDispatcher("manageStaff.jsp").forward(request, response);
			
			
		}
		else {
			request.setAttribute("msg", "Session Expired. Please login again.");
	        request.getRequestDispatcher("sessionExpAdmin.jsp").forward(request, response);
		}
	}

}
























