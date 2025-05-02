package com.ashi.controllers;

import java.io.IOException;

import com.ashi.BeansandDAOs.AdminBean;
import com.ashi.BeansandDAOs.AdminDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/updateAdminProfile")
public class UpdateAdminServlet extends HttpServlet {
	 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hSession = request.getSession(false);
		if(hSession != null) {

			//get data from the form[name]
			
			String oldPassword = request.getParameter("oldPassword").trim();
			String newPassword = request.getParameter("newPassword").trim();
			
			//check the old password is valid or not
			AdminBean admin = (AdminBean)hSession.getAttribute("adminBean");
			//System.out.println(admin);
			if(admin.getPassword().equals(oldPassword)) {
				
				int k = new AdminDAO().passwordChange(newPassword);
				if(k > 0 ) {
					
					request.setAttribute("msg", "password changed");
					request.getRequestDispatcher("adminProfile.jsp").forward(request, response);
				}
				else {
					request.setAttribute("msg", "error in the admin password change");
					request.getRequestDispatcher("errorPage.jsp").forward(request, response);
				}
				
			}
			else {
				request.setAttribute("msg", "old password incorrect");
				request.getRequestDispatcher("adminProfile.jsp").forward(request, response);
			}
		}
		else {
			  request.setAttribute("msg", "Session Expired. Please login again.");
	          request.getRequestDispatcher("sessionExpAdmin.jsp").forward(request, response);
		}
		
		
		
	}

}
