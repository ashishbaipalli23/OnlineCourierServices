package com.ashi.controllers;

import java.io.IOException;
import java.util.List;

import com.ashi.BeansandDAOs.StaffDAO;
import com.ashi.BeansandDAOs.StaffPerformanceBean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/viewStaffPerformance")
public class ViewStaffPerformanceServlet extends HttpServlet{


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		 HttpSession  httpSession = request.getSession(false);
		 if(httpSession != null) {
			   StaffDAO dao = new StaffDAO();
	            List<StaffPerformanceBean> staffList= dao.getAllStaffPerformance();
	           // System.out.println(staffList);
	            request.setAttribute("staffPerformanceList", staffList);
	            RequestDispatcher rd = request.getRequestDispatcher("viewStaffPerformance.jsp");
	            rd.forward(request, response);

		 }
		 else {
			 request.setAttribute("msg", "Session Expired. Please login again.");
	            request.getRequestDispatcher("sessionExpAdmin.jsp").forward(request, response);
		 }
		
		
	}
	
}
















