package com.ashi.controllers;

import java.io.IOException;
import java.io.InputStream;

import com.ashi.BeansandDAOs.DeliveryAgentBean;
import com.ashi.BeansandDAOs.DeliveryAgentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@MultipartConfig
@SuppressWarnings("serial")
@WebServlet("/addDeliveryStaff")
public class AddDeliveryStaffServlet  extends HttpServlet{

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
			HttpSession hSession = request.getSession(false);
			if(hSession != null) {
				//collect data from the form[name]
				String name = new String(request.getPart("name").getInputStream().readAllBytes());
				String phone = new String(request.getPart("phone").getInputStream().readAllBytes());
				String userId = new String(request.getPart("userId").getInputStream().readAllBytes());
				String password = new String(request.getPart("password").getInputStream().readAllBytes());

				//get data and changed to  stream
				Part photo = request.getPart("photo");
				InputStream photoInputStream = null;
				if (photo != null && photo.getSize() > 0) {
				    photoInputStream = photo.getInputStream();
				}
				
				DeliveryAgentBean agent = new DeliveryAgentBean();
				agent.setName(name);
				agent.setPhone(phone);
				agent.setUserId(userId);
				agent.setPassword(password);

				
				
				boolean success = new DeliveryAgentDAO().addDeliveryStaff(agent, photoInputStream);

				if (success) {
				    request.setAttribute("success", "Staff added successfully!");
				} else {
				    request.setAttribute("error", "Failed to add staff. Try again.");
				}

				request.getRequestDispatcher("addStaff.jsp").forward(request, response);  
				
			}
			else {
				request.setAttribute("msg", "Session Expired. Please login again.");
		           request.getRequestDispatcher("sessionExpAdmin.jsp").forward(request, response);
			}
			
		}
}
