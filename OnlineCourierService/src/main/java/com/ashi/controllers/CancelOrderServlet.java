package com.ashi.controllers;

import java.io.IOException;

import com.ashi.BeansandDAOs.OrdersDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/cancelOrder")
public class CancelOrderServlet extends HttpServlet {
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession hSession = request.getSession(false);
    	if(hSession != null) {
    		//URL rewriting orderId is in Request object 
        	//collect the orderId from the request object and update the order table , status = cancle ,orderId = ?
        	int orderId = Integer.parseInt(request.getParameter("orderId"));
        	int k = new OrdersDAO().cancelOrder(orderId);
        	if(k > 0) {
        	   // System.out.println("Canceled order success");
        		request.setAttribute("msg", "Order Canceled");   
        		request.getRequestDispatcher("orderCancled.jsp").forward(request, response);
        	}
        	else {
        		request.setAttribute("msg", "Error in cancled Order");
        		request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        	}
        	
    	}
    	else {
    		 request.setAttribute("msg", "Session Expired. Please login again.");
             request.getRequestDispatcher("sessionExp.jsp").forward(request, response);
    	}
    	
    	
    }
}
