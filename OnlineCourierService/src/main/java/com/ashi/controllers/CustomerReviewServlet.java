package com.ashi.controllers;

import java.io.IOException;
import java.util.List;

import com.ashi.BeansandDAOs.ReviewBean;
import com.ashi.BeansandDAOs.ReviewDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/customerReviews")
public class CustomerReviewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession httpSession  = request.getSession(false);
		 if(httpSession != null) {
			 ReviewDAO dao = new ReviewDAO();
		        List<ReviewBean> reviewList = dao.getAllReviews(); // No filtering by staff

		        request.setAttribute("reviewList", reviewList);
		      request.getRequestDispatcher("adminViewReviews.jsp").forward(request, response);;
		 }
		 else {
			 request.setAttribute("msg", "Session Expried Please Login Again");
			 request.getRequestDispatcher("sessionExpAdmin.jsp").forward(request, response);
		 }
	}
}






























