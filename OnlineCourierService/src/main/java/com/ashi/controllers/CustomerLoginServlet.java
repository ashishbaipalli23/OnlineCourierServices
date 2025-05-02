package com.ashi.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.ashi.BeansandDAOs.CustomerBean;
import com.ashi.BeansandDAOs.CustomerDAO;


@SuppressWarnings("serial")
@WebServlet("/customerLogin")
public class CustomerLoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//username ,password -> login.jsp form name
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		
		CustomerBean customerBean = new CustomerDAO().login(username, password);
		if(customerBean != null) {
			//System.out.println("login success");
			
			HttpSession hSession = request.getSession();
			hSession.setAttribute("customerBean",customerBean);
			
			response.sendRedirect("customerDashboard.jsp");
		}
		else {
			request.setAttribute("msg", "Invalid Login Credentials ");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	    
	}

}
