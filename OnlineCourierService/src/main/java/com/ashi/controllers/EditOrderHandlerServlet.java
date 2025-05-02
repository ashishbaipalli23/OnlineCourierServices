package com.ashi.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.ashi.BeansandDAOs.CourierBean;
import com.ashi.BeansandDAOs.CourierDAO;


@WebServlet("/editOrderHandler")
public class EditOrderHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     HttpSession httpSession = request.getSession(false);
	     if(httpSession != null) {
	    	 //get Courier bean from the session object 
	    	 CourierBean cBean = (CourierBean)httpSession.getAttribute("courierBean");
	    	// System.out.println("before edit :"+cBean);
	    	 //get data from  the request object 
	    	 //pickup , destination, weight, type -> form [name]
	    	 
	    	//  System.out.println(cBean);
	    	 	// Get updated fields from the form
				String pickup = request.getParameter("pickup");
				String destination = request.getParameter("destination");
				double weight = Double.parseDouble(request.getParameter("weight"));
				String type = request.getParameter("type");

				// Update CourierBean fields
				cBean.setPickupLocation(pickup);
				cBean.setDestination(destination);
				cBean.setWeight(weight);
				cBean.setType(type);

				// Update booking date and expected delivery
				Timestamp now = Timestamp.valueOf(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
				Timestamp expected = Timestamp.valueOf(LocalDateTime.now().plusDays(3).truncatedTo(ChronoUnit.SECONDS));

				cBean.setBooking_date(now);
				cBean.setExpected_delivery(expected);

				// Optional: update cost again based on logic
				//per kg =>> 50/-
				double cost = weight * 50.0; // Example logic
				cBean.setCost(cost);
                
			//	System.out.println("after edid courier : "+cBean);
				
				int k = new CourierDAO().updateCourierDetails(cBean);
				
				if(k > 0) {
					//System.out.println("Order updated");
					request.setAttribute("msg","Order Updated Successfully");
					request.getRequestDispatcher("courierBookingDashBoard.jsp").forward(request, response);
				}
				else {
					request.setAttribute("msg", "Error in the updateOrder");
					request.getRequestDispatcher("errorPage.jsp").forward(request, response);
					
				
				}
	    	    
				
	    	 
	    	 
	    	 
	    	 
	    	 
	     }
	     else {
	    	    request.setAttribute("msg", "Session Expired. Please login again.");
	            request.getRequestDispatcher("sessionExp.jsp").forward(request, response);
	     }
	}

}
