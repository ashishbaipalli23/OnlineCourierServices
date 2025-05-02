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
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteAgent")
public class DeleteAgentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession httpSession = request.getSession(false);
         if(httpSession != null) {

             // 1. Get agent ID from form[hidden]
             int agentId = Integer.parseInt(request.getParameter("agentId"));
             
             // 2. Delete agent from DB before that check if the agent is not assigend to orders or not
             
              boolean isAsigneToOrder = new DeliveryAgentDAO().isAgentLinkedToOrders(agentId);
              if (!isAsigneToOrder) {
                  // 3. Safe to delete
                  int k = new DeliveryAgentDAO().deleteAgent(agentId);

                  if (k > 0) {
                      // 4. After delete, fetch updated agents list
                      List<DeliveryAgentBean> updatedAgents = new DeliveryAgentDAO().getAgents();
                      request.setAttribute("agents", updatedAgents);

                      // 5. Success message
                      request.setAttribute("deleteSuccess", "Agent deleted successfully.");
                      request.getRequestDispatcher("manageStaff.jsp").forward(request, response);
                  } else {
                      // Deletion failed due to unknown reason
                      request.setAttribute("msg", "Error deleting the agent.");
                      request.getRequestDispatcher("errorPage.jsp").forward(request, response);
                  }
              } else {
                  // Cannot delete, agent assigned to orders
                  List<DeliveryAgentBean> updatedAgents = new DeliveryAgentDAO().getAgents();
                  request.setAttribute("agents", updatedAgents);

                  request.setAttribute("deleteError", "Cannot delete agent. This agent is assigned to one or more orders.");
                  request.getRequestDispatcher("manageStaff.jsp").forward(request, response);
              }
            
         }
         
         else {
       	  request.setAttribute("msg", "Session Expired. Please login again.");
          request.getRequestDispatcher("sessionExpAdmin.jsp").forward(request, response); 
         }
    }
}
