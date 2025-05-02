package com.ashi.controllers;

import java.io.IOException;
import java.util.*;
import com.ashi.BeansandDAOs.CustomerBean;
import com.ashi.BeansandDAOs.PaymentBean;
import com.ashi.BeansandDAOs.PaymentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/paymentHistory")
public class PaymentHistoryServlet extends HttpServlet{
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession  = request.getSession(false);
		if(httpSession != null) {
			//get the customerBean from the session object 
			CustomerBean customerBean = (CustomerBean)httpSession.getAttribute("customerBean");
			//get id from it add pass to paymentDAO
			//System.out.println(customerBean);
			List<PaymentBean> payments = new PaymentDAO().getPaymentHistory(customerBean.getCustomer_id());
			//System.out.println(payments);
			request.setAttribute("paymentList", payments);
			request.getRequestDispatcher("paymentHistory.jsp").forward(request, response);
			
		}
		else {
			  request.setAttribute("msg", "Session Expired. Please login again.");
	          request.getRequestDispatcher("sessionExp.jsp").forward(request, response);
		}
	}

}
