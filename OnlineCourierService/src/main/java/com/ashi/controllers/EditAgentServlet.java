package com.ashi.controllers;

import java.io.IOException;
import java.util.List;

import com.ashi.BeansandDAOs.DeliveryAgentBean;
import com.ashi.BeansandDAOs.DeliveryAgentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editAgent")
public class EditAgentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get form data
        int agentId = Integer.parseInt(request.getParameter("agentId"));
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
      

        // Update the agent in the database
        DeliveryAgentDAO dao = new DeliveryAgentDAO();
        boolean success = dao.updateAgent(agentId, name, phone, userId, password);

        if (success) {
        	// 3. After success, fetch updated list
            List<DeliveryAgentBean> updatedAgents = new DeliveryAgentDAO().getAgents();

            // 4. Set the list back to request
            request.setAttribute("agents", updatedAgents);

            // 5. Forward (not redirect)
            request.getRequestDispatcher("manageStaff.jsp").forward(request, response);
        } else {
            // Handle failure
            response.getWriter().println("Failed to update agent details.");
        }
    }
}
