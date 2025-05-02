<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Profile</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        background: linear-gradient(to right, #f8f9fa, #e0f7fa);
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }
    .profile-form {
        max-width: 600px;
        margin: 50px auto;
        background: #ffffff;
        padding: 30px;
        border-radius: 15px;
        box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.1);
    }
    .form-control {
        border-radius: 10px;
    }
  
</style>
</head>
<body>

<%@ include file="navbarAdmin.jsp" %>

<%
AdminBean aBean = (AdminBean)session.getAttribute("adminBean");

if (aBean == null) {
	session.setAttribute("sessionExp", "session Expried login again");
    response.sendRedirect("adminLogin.jsp");
    return;
}
%>

<div class="container">
                <!-- Alert messages if available -->
<div class="container mt-3 w-50">
    <% 
        String msg = (String) request.getAttribute("msg");
     
        
        if (msg != null) { 
    %>
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <%= msg %>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    <%} %>
</div>

    <div class="profile-form">

        <h2 class="text-center mb-4">Admin Profile</h2>
        
        <form action="updateAdminProfile" method="post">

            <div class="mb-3">
                <label class="form-label">Username</label>   
                <input type="text" class="form-control" name="username" value="<%= aBean.getUsername() %>" disabled> 
            </div>

            <div class="mb-3">
                <label class="form-label">Email</label>   
                <input type="email" class="form-control" name="email" value=<%= aBean.getEmail() %> disabled> 
            </div>

            <div class="mb-3">
                <label class="form-label">Role</label>   
                <input type="text" class="form-control" value="<%= aBean.getRole() %>" disabled> 
            </div>
             
            <div class="mb-3">
                <label class="form-label">Old Password</label>   
                <input type="password" class="form-control" name="oldPassword" placeholder="Enter old password" required> 
            </div>
             
            <div class="mb-3">
                <label class="form-label">New Password</label>   
                <input type="password" class="form-control" name="newPassword" placeholder="Enter new password" required> 
            </div>

            <div class="d-grid">
                <div class="row">
                
                	<div class="col">
                	   <a href="adminDashBoard.jsp" class="btn btn-warning form-control">Back</a>
                	</div>
                	<div class="col">
                	  <button type="submit" class="btn btn-success form-control">Update Profile</button>
                	</div>
                </div>
            </div>

        </form>
    </div>
</div>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
