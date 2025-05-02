<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delivery Agent Login</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Icons -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

<style>
    .navbar-brand {
        font-weight: bold;
        font-size: large;
    }
     body {
      background-color: #f2f2f2;
    }
</style>
</head>
<body class="bg-light">

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark py-3">
    <div class="container">
        <a class="navbar-brand text-light" href="#">Online Courier Services</a>
    </div>
</nav>

<!-- Login Form -->
<div class="container d-flex justify-content-center align-items-center" style="min-height: 80vh;">
    <div class="col-md-6 col-lg-5 bg-white p-5 rounded shadow">
	
		<!-- Alert Message -->
        <%
            String msg = (String) request.getAttribute("msg");
            if (msg != null) {
        %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
               
                <%= msg %>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        <%
            }
        %>
        

        <h3 class="text-center mb-4">Delivery Agent Login</h3>

        <form action="deliveryAgentLogin" method="post">
            <div class="mb-3">
                <label for="userID" class="form-label">UserID</label>
                <input type="text" name="userID" class="form-control" id="userID" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" name="password" class="form-control" id="password" required>
            </div>
            <div class="d-grid">
                <div class="row">
                   <div class="col">
                     <a href="index.html" class="btn btn-warning form-control">GoBack</a>
                   </div>
                   <div class="col">
	                   <button type="submit" class="btn btn-dark form-control">
	                    <i class="bi bi-box-arrow-in-right me-1 "></i> Login
	                </button>
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
