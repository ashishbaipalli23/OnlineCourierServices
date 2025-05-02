<%@ page import="com.ashi.BeansandDAOs.CustomerBean" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Customer Profile Update</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f8f9fa;
    }
    .form-card {
      max-width: 500px;
      margin: 10px auto;
      border-radius: 15px;
      box-shadow: 0 0 15px rgba(0,0,0,0.1);
    }
    .form-card .card-body {
      padding: 30px;
    }
  </style>
</head>
<body>

<%@ include file="navBarSuccess.jsp" %>

<%
  CustomerBean cbean = (CustomerBean) session.getAttribute("customerBean");
  if (cbean == null) {
	//write some login session exprieed
    response.sendRedirect("login.jsp");
    return;
  }
  
%>

<div class="card form-card">
    
  <div class="card-body">
    <%
  String msg  = (String)session.getAttribute("msg");
  if(msg != null){
%>
  
    <div class="alert alert-warning alert-dismissible fade show" role="alert">
      <strong><i class="bi bi-info-circle-fill"></i> Message:</strong> <%= msg %>
      <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>

<%
  }
  session.removeAttribute("msg");
%>
    <h4 class="text-center text-primary mb-4">Update Your Profile</h4>
    <form action="updateCustomerProfile" method="post">
      
      <div class="mb-3">
        <label for="name" class="form-label">Full Name</label>
        <input type="text" class="form-control" id="name" name="name" value="<%= cbean.getName() %>" required>
      </div>

      <div class="mb-3">
        <label for="username" class="form-label">Username</label>
        <input type="text" class="form-control  bg-info text-light" id="username" name="username" value="<%= cbean.getUsername() %>" readonly>
      </div>

      <div class="mb-3">
        <label for="phone" class="form-label">Phone</label>
        <input type="text" class="form-control" id="phone" name="phone" value="<%= cbean.getPhone() %>" required>
      </div>

      <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" class="form-control bg-info  text-light" id="email" name="email" value="<%= cbean.getEmail() %>" readonly>
      </div>

      <div class="mb-3">
        <label for="address" class="form-label">Address</label>
        <textarea class="form-control" id="address" name="address" rows="3" required><%= cbean.getAddress() %></textarea>
      </div>

      <div class="d-grid">
         <div class="row">
            <div class="col">
               <a href="customerDashboard.jsp" class="btn btn-warning form-control" >GoBack</a>
            </div>
            <div class="col">
                <button type="submit" class="btn btn-success form-control">Update Profile</button>
            </div>
         </div>
      </div>
    </form>
  </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
