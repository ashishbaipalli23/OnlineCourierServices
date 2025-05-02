<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ashi.BeansandDAOs.DeliveryAgentBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agent Profile</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

    <style>
        body {
            background-color: #f4f7f6;
        }
        .profile-card {
            max-width: 420px;
            margin: 50px auto;
        }
        .profile-img {
            width: 120px;
            height: 120px;
            object-fit: cover;
            border-radius: 50%;
            border: 3px solid #4caf50;
        }
        .form-control-sm {
            font-size: 0.9rem;
            padding: 0.4rem 0.6rem;
        }
        .btn-sm {
            font-size: 0.9rem;
            padding: 0.4rem 0.75rem;
        }
    </style>
</head>
<body>

<%@ include file="navbarAgent.jsp" %>

<%
    DeliveryAgentBean aBean = (DeliveryAgentBean)session.getAttribute("agentBean");
%>

<div class="container">
   
    

    <div class="card profile-card shadow-lg p-3">
         <% if (request.getAttribute("msg") != null) { %>
    <div class="alert alert-info alert-sm alert-dismissible fade show" role="alert">
        <%= request.getAttribute("msg") %>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
<% } %>
    
        <div class="card-body text-center">
            <h5 class="card-title mb-3 text-success"><i class="bi bi-person-circle me-1"></i>Agent Profile</h5>
            
            <% if (aBean.getPhoto() != null) { %>
                <img src="agentPhoto?id=<%= aBean.getStaffId() %>" class="profile-img mb-2" alt="Agent Photo">
            <% } else { %>
                <img src="default-user.png" class="profile-img mb-2" alt="Default Photo">
            <% } %>

            <p class="mb-1"><i class="bi bi-person-fill me-1"></i><strong>Name:</strong> <%= aBean.getName() %></p>
            <p class="mb-1"><i class="bi bi-telephone-fill me-1"></i><strong>Phone:</strong> <%= aBean.getPhone() %></p>
            <p class="mb-1"><i class="bi bi-person-badge me-1"></i><strong>User ID:</strong> <%= aBean.getUserId() %></p>
            <p class="mb-3"><i class="bi bi-hash me-1"></i><strong>Staff ID:</strong> <%= aBean.getStaffId() %></p>

            <h6 class="text-primary mt-3 mb-2"><i class="bi bi-key me-1"></i>Change Password</h6>
            <form action="updateAgentPassword" method="post">
                <div class="mb-2">
                    <input type="password" name="oldPassword" class="form-control form-control-sm" placeholder="Current Password" required>
                </div>
                <div class="mb-2">
                    <input type="password" name="newPassword" class="form-control form-control-sm" placeholder="New Password" required>
                </div>
                <div class="row">
                  <div class="col">
                    <a href="agentDashBoard.jsp" class="btn btn-warning btn-sm form-control">DashBoard</a>
                  </div>
                 <div class="col">
                   <button type="submit" class="btn btn-success btn-sm form-control">
                    <i class="bi bi-arrow-repeat me-1"></i>Update Password
                </button>
                 </div>
                
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
