
package com.ashi.controllers;

import java.io.IOException;
import java.sql.Timestamp;

import com.ashi.BeansandDAOs.CourierBean;
import com.ashi.BeansandDAOs.CourierDAO;
import com.ashi.BeansandDAOs.CustomerBean;
import com.ashi.BeansandDAOs.OrderBean;
import com.ashi.BeansandDAOs.OrdersDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/bookCourierService")
public class BookCourierServiceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession hSession = request.getSession(false);

        if (hSession != null) {

            // 1. Get form data
            String pickup = request.getParameter("pickup");
            String destination = request.getParameter("destination");
            double weight = Double.parseDouble(request.getParameter("weight"));
            String[] typeArr = request.getParameterValues("type");

            // 2. Calculate cost (example: Rs.50 per kg)
            double baseRate = 50.0;
            double cost = weight * baseRate;

            // 3. Set dates
            Timestamp bookingDate = new Timestamp(System.currentTimeMillis());

            // Expected delivery = booking + 3 days
            long deliveryMillis = 3L * 24 * 60 * 60 * 1000;
            Timestamp expectedDelivery = new Timestamp(System.currentTimeMillis() + deliveryMillis);

            // 4. Get customerBean from session
            CustomerBean customerBean = (CustomerBean)hSession.getAttribute("customerBean");

            // 5. Create and populate CourierBean
            CourierBean cb = new CourierBean();
            cb.setPickupLocation(pickup);
            cb.setDestination(destination);
            cb.setWeight(weight);
            cb.setType(typeArr[0]);
            cb.setCost(cost);
            cb.setBooking_date(bookingDate);
            cb.setExpected_delivery(expectedDelivery);
            cb.setCustomer_id(customerBean.getCustomer_id()); // Foreign key relationship

            // 6. Insert into DB and get the courier_id
            int result = new CourierDAO().addCourier(cb);

            // 7. Forward to result page
            if (result > 0) {
                // Courier booked successfully, now insert into orders table
                OrderBean orderBean = new OrderBean();
                orderBean.setStatus("Pending");
                orderBean.setCustomer_id(customerBean.getCustomer_id());
                orderBean.setCourier_id(cb.getCourier_id()); // Set courier_id after it's generated
                
                
                int k = new OrdersDAO().placeOrder(orderBean);
                if (k > 0) {
                	
                    request.setAttribute("msg", "Courier/order Placed Successfully!");
                   // request.setAttribute("courierBean", cb);
                    hSession.setAttribute("courierBean", cb);
                    //display the order summary
                    request.getRequestDispatcher("courierBookingDashBoard.jsp").forward(request, response);
                    
                    
                } else {
                    //System.out.println("Error in placing the order");
                	request.setAttribute("msg", "Error in placing the order");
                	request.getRequestDispatcher("erroPage.jsp").forward(request, response);
                }

            } else {
               //  System.out.println("Error in courier booking");
            	request.setAttribute("msg", "Error in courier booking");
            	request.getRequestDispatcher("erroPage.jsp").forward(request, response);
            }

        } else {
            request.setAttribute("msg", "Session Expired. Please login again.");
            request.getRequestDispatcher("sessionExp.jsp").forward(request, response);
        }
    }
}
