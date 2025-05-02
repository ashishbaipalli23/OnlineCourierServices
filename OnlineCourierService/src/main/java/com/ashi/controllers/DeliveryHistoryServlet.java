package com.ashi.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.ashi.BeansandDAOs.DeliveryAgentBean;
import com.ashi.BeansandDAOs.OrderBean;
import com.ashi.BeansandDAOs.OrdersDAO;

@SuppressWarnings("serial")
@WebServlet("/deliveryHistory")
public class DeliveryHistoryServlet extends HttpServlet {
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        HttpSession session = request.getSession(false);
	        if (session != null) {
	            DeliveryAgentBean agent = (DeliveryAgentBean) session.getAttribute("agentBean");
	            int staffId = agent.getStaffId();

	            OrdersDAO dao = new OrdersDAO();
	            List<OrderBean> history = dao.getDeliveryHistory(staffId);

	            request.setAttribute("history", history);
	            request.getRequestDispatcher("deliveryHistory.jsp").forward(request, response);
	        } else {
	            request.setAttribute("msg", "Session expired. Please login again.");
	            request.getRequestDispatcher("sessionExpAgent.jsp").forward(request, response);
	        }
	    }
	

}

