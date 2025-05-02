package com.ashi.controllers;

import java.io.IOException;
import java.util.List;

import com.ashi.BeansandDAOs.DeliveryAgentBean;
import com.ashi.BeansandDAOs.ReviewBean;
import com.ashi.BeansandDAOs.ReviewDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ViewAgentReviews")
public class ViewAgentReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null) {
			DeliveryAgentBean agent = (DeliveryAgentBean)session.getAttribute("agentBean");
			
			int staffId = agent.getStaffId();

			ReviewDAO dao = new ReviewDAO();
			List<ReviewBean> reviewList = dao.getReviewsByStaffId(staffId);
             
			request.setAttribute("reviewList", reviewList);
			request.getRequestDispatcher("viewAgentReviews.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Session Expired. Please log in again.");
			request.getRequestDispatcher("sessionExpAgent.jsp").forward(request, response);
		}
	}
}
