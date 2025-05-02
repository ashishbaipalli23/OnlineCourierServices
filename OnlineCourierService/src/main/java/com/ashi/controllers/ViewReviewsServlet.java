package com.ashi.controllers;

import java.io.IOException;
import java.util.List;

import com.ashi.BeansandDAOs.CustomerBean;
import com.ashi.BeansandDAOs.ReviewBean;
import com.ashi.BeansandDAOs.ReviewDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/viewReviews")
public class ViewReviewsServlet extends HttpServlet {
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	
    	HttpSession httpSession = request.getSession();
    	if(httpSession != null) {
    		
    		//get the customerId from the session object 
    		CustomerBean cBean = (CustomerBean)httpSession.getAttribute("customerBean");
    		int customerId = cBean.getCustomer_id();
    		
    		List<ReviewBean> reviewList = new ReviewDAO().getReviewsByCustomerId(customerId);
    		
    		request.setAttribute("reviews", reviewList);
    		request.getRequestDispatcher("viewReviews.jsp").forward(request, response);
    		
    		
    	}
    	else {
    		
    		request.setAttribute("msg", "Session Expried Please Login Again");
			request.getRequestDispatcher("sessionExp.jsp").forward(request, response);
    		
    	}
    
    		
    	
    	
    }

}




















