package com.ashi.controllers;

import java.io.IOException;
import java.util.List;

import com.ashi.BeansandDAOs.CustomerBean;
import com.ashi.BeansandDAOs.OrderDetailsBean;
import com.ashi.BeansandDAOs.OrderDetailsDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/viewOrders")
public class ViewOrdersServlet extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   HttpSession hSession = request.getSession(false);
		   
		   if(hSession != null) {
			   
			   //get customerId for the session object 
			   CustomerBean customerBean = (CustomerBean)hSession.getAttribute("customerBean");
			   int customerId = customerBean.getCustomer_id();
	            
	            // Fetch past orders using DAO
	            List<OrderDetailsBean> orders = new OrderDetailsDAO().getPastOrdersByCustomer(customerId);
	            
	            request.setAttribute("orderList", orders);
	            request.getRequestDispatcher("viewOrders.jsp").forward(request, response);
		   }
		   else {
				request.setAttribute("msg", "Session Expried Please Login Again");
				request.getRequestDispatcher("sessionExp.jsp").forward(request, response);
		   }
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		}
}
