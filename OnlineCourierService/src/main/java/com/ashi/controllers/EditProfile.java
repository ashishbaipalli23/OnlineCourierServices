package com.ashi.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/editProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hSession = request.getSession(false);
		if(hSession != null) {
			request.getRequestDispatcher("customerProfileUpdate.jsp").forward(request, response);
		}
		else {
			request.setAttribute("msg", "Session Expried Please Login Again");
			request.getRequestDispatcher("sessionExp.jsp").forward(request, response);
		}
	}

	

}
