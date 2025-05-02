package com.ashi.controllers;

import java.io.IOException;

import com.ashi.BeansandDAOs.ReviewDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/submitReview")
public class SubmitReviewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int rating = Integer.parseInt(request.getParameter("rating"));
        String comments = request.getParameter("comments");
        
        ReviewDAO dao = new ReviewDAO();
        
        int staffId = dao.getStaffIdByOrderId(orderId);
        boolean inserted = dao.insertReview(orderId, customerId, staffId, rating, comments);

        if (inserted) {
            request.setAttribute("msg", "Review submitted successfully!");
        } else {
            request.setAttribute("msg", "Failed to submit review or review already exists.");
        }
        request.getRequestDispatcher("customerDashboard.jsp").forward(request, response);
    }
}
