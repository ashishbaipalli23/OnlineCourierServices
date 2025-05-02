package com.ashi.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.ashi.BeansandDAOs.AdminBean;
import com.ashi.BeansandDAOs.AdminDAO;


@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  //get data from the form[name]
		  
		   String username = request.getParameter("username");
		   String password = request.getParameter("password");
		   
		    AdminBean admin = new AdminDAO().login(username, password);
		    if(admin != null) {
		    	//add adminBean to session object 
		    	HttpSession hSession = request.getSession();
		    	hSession.setAttribute("adminBean",admin);
		    	request.getRequestDispatcher("adminDashBoard.jsp").forward(request, response);
		    }
		    else {
		    	request.setAttribute("msg","Invalid Credentials !");
		    	request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
		    }
		
	}

}
