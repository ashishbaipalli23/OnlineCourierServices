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


@WebServlet("/updateCustomerProfile")
public class UpdateCustomerProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     HttpSession hSession = request.getSession(false);
	     if(hSession != null) {
	    	   //name username phone email address => form data names
	    	    String name = request.getParameter("name");
	    	    String username= request.getParameter("username");
	    	    String phone = request.getParameter("phone");
	    	    String email = request.getParameter("email");
	    	    String address = request.getParameter("address");
	    	    
	    	   CustomerBean cBean = new CustomerBean();
	    	   //these are updated details
	    	   
	    	   cBean.setPhone(phone);
	    	   cBean.setName(name);
	    	   cBean.setAddress(address);
	    	  
	    	   //hidden details
	    	   cBean.setUsername(username);
	    	   cBean.setEmail(email);
	    	   
	    	   int k = new CustomerDAO().updateProfile(cBean);
	    	   if(k > 0) {
	    		    //System.out.println("profile updated");
	    		   //update in customerBean present in >> Session object
	    		   CustomerBean cb = (CustomerBean)hSession.getAttribute("customerBean");
	    		   cb.setName(cBean.getName());
	    		   cb.setAddress(cBean.getAddress());
	    		   cb.setPhone(cBean.getPhone());
	    		   
	    		   hSession.setAttribute("msg", "profile updated");
	    		   response.sendRedirect("customerProfileUpdate.jsp");
	    	   }
	    	   else {
	    		   //System.out.println("error in profile update");
	    		   hSession.setAttribute("msg", "error in profile update");
	    		   response.sendRedirect("customerProfileUpdate.jsp");
	    	   }
	     }
	     else {
				request.setAttribute("msg", "Session Expried Please Login Again");
				request.getRequestDispatcher("sessionExp.jsp").forward(request, response);
			}

	}

}
