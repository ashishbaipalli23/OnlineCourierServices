package com.ashi.controllers;

import java.io.IOException;

import java.sql.Timestamp;

import com.ashi.BeansandDAOs.PaymentBean;
import com.ashi.BeansandDAOs.PaymentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/paymentHandler")
public class PaymentHandlerServlet extends HttpServlet {
	
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession httpSession = request.getSession(false);
			if(httpSession != null) {
				//get data from the form[name]
				 // 1. Read data from request [type = "hidden"]
	            int orderId = Integer.parseInt(request.getParameter("orderId"));
	            double amount = Double.parseDouble(request.getParameter("amount"));
	            int customerId = Integer.parseInt(request.getParameter("customerId"));
	            String paymentMethod = request.getParameter("paymentMethod");
	            
	          //this data is added to payment table 
	            PaymentBean payment = new PaymentBean();
	            payment.setOrderId(orderId);
	            payment.setAmount(amount);
	            payment.setCustomerId(customerId);
	            payment.setPaymentMethod(paymentMethod);
	            payment.setPaymentDate(new Timestamp(System.currentTimeMillis())); // Optional which is auto generated in table
	            
	            //if paymentmethod is COD
	            
	            if ("Cash on Delivery".equals(paymentMethod)) {
	                payment.setStatus("Pending");
	            } else {
	                // For now we simulate success — you could integrate a real gateway here
	                payment.setStatus("Success");
	            }
	          
	            int k = new PaymentDAO().savePayment(payment);
	            if(k > 0) {
	            	//System.out.println("payment saved");
	                 request.setAttribute("msg", "Payment Success");
	                 request.getRequestDispatcher("paymentSuccess.jsp").forward(request, response);
	                 
	            }
	            else {
	                  request.setAttribute("msg", "Error in payment please login again");
	                  request.getRequestDispatcher("errorPage.jsp").forward(request, response);
	            }
	            
	            
			}
			else {
				 request.setAttribute("msg", "Session Expired. Please login again.");
		         request.getRequestDispatcher("sessionExp.jsp").forward(request, response);
			}
		}
}
