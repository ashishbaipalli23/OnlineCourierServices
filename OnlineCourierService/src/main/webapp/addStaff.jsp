<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Delivery Staff</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%@ include file="navbarAdmin.jsp" %>

<div class="container mt-5 col-md-5">
    <% 
       //check the session is expried or not
       if(request.getSession(false) == null){
    	   request.setAttribute("msg", "Session Expired. Please login again.");
           request.getRequestDispatcher("sessionExpAdmin.jsp.jsp").forward(request, response);
           return;
       }
    
        String success = (String) request.getAttribute("success");
        String error = (String) request.getAttribute("error");
        
        if (success != null) { 
    %>
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <%= success %>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    <% 
        } else if (error != null) { 
    %>
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <%= error %>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    <% 
        } 
    %>

    <div class="card shadow p-4">
        <h2 class="mb-4 text-center">Add Delivery Staff</h2>
        <form action="addDeliveryStaff" method="post" enctype="multipart/form-data" class="p-3">
            <div class="mb-3">
                <label class="form-lable">Name</label>
                <input type="text" name="name" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Phone</label>
                <input type="text" name="phone" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>UserID</label>
                <input type="text" name="userId" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Password</label>
                <input type="text" name="password" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Photo</label>
                <input type="file" name="photo" class="form-control" required>
            </div>
            <div class="d-grid">
               <div class="row">
                   <div class="col">
                     <a href="adminDashBoard.jsp" class="btn btn-warning form-control">Back</a>
                   </div>
                      	<div class="col">
                      	   <button type="submit" class="btn btn-success form-control">Add Staff</button>
                      	</div>
               </div>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
