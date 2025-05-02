package com.ashi.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ashi.BeansandDAOs.CustomerBean;
import com.ashi.BeansandDAOs.CustomerDAO;


@SuppressWarnings("serial")
@WebServlet("/customerRegistration")
public class CustomerRegistrationServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//name , username , password , address, phone, email used in reg.html form 
		String customerName = request.getParameter("name");
		String username = request.getParameter("username");
		String password  = request.getParameter("password");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email  = request.getParameter("email");
		 
		CustomerBean cb = new CustomerBean();
		cb.setName(customerName);
		cb.setUsername(username);
		cb.setPassword(password);
		cb.setAddress(address);
		cb.setPhone(phone);
		cb.setEmail(email);
		//System.out.println(cb);
		
		int k = new CustomerDAO().register(cb);
		if(k > 0) {
			request.setAttribute("msg", "Registration Succesfull");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		else {
			request.setAttribute("msg", "An Error occured in Regstration try again..");
			request.getRequestDispatcher("errorPage.jsp").forward(request, response);
		}
	}

}


