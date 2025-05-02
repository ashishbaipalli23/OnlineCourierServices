package com.ashi.controllers;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.ashi.BeansandDAOs.DeliveryAgentDAO;

@SuppressWarnings("serial")
@WebServlet("/agentPhoto")
public class AgentPhotoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int staffId = Integer.parseInt(request.getParameter("id"));
        
        // Fetch the image InputStream from the database
        DeliveryAgentDAO agentDAO = new DeliveryAgentDAO();
        InputStream photoStream = agentDAO.getAgentPhotoById(staffId);
        
        if (photoStream != null) {
            // Use BufferedInputStream for better performance
            BufferedInputStream bufferedInputStream = new BufferedInputStream(photoStream);
            
            response.setContentType("image/jpeg");
            OutputStream os = response.getOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            
            // Read and write the buffered data in chunks
            while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            
            // Close the streams
            bufferedInputStream.close();
            os.flush();
        } else {
            // Fallback image or error
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "No photo found");
        }
    }
}