package com.ashi.controllers;

import java.io.IOException;

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
@WebServlet("/trackCourier")
public class TrackCourierServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession httpSession = request.getSession(false);
    	if(httpSession != null) {
    		int orderId = Integer.parseInt(request.getParameter("orderId"));
    		CustomerBean customerBean = (CustomerBean)httpSession.getAttribute("customerBean");
    		int cid = customerBean.getCustomer_id();
            OrderDetailsBean order = new OrderDetailsDAO().getOrderDetailsById(orderId,cid);

            if (order != null) {
                request.setAttribute("order", order);
            } else {
                request.setAttribute("msg", "No courier found with Order ID: " + orderId);
            }

            // Forward back to same page
            request.getRequestDispatcher("trackCourier.jsp").forward(request, response);
        }
    	else {
    		request.setAttribute("msg", "Session Expried Please Login Again");
			request.getRequestDispatcher("sessionExp.jsp").forward(request, response);
    	}
    }
    	
   }

