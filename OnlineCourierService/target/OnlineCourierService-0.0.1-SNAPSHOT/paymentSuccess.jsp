<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Page</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

<style>
    body {
        background-color: #f4f6f9;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    .card {
        max-width: 600px;
        margin: 50px auto;
        border-radius: 15px;
        box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
    }

    .card-header {
        background: linear-gradient(135deg, #00c6ff, #0072ff);
        color: white;
        font-size: 1.5rem;
        font-weight: bold;
        text-align: center;
        border-radius: 15px 15px 0 0;
    }

    .card-body {
        padding: 30px;
        text-align: center;
        background-color: #ffffff;
    }

    .card-body a.btn {
        margin: 10px;
        border-radius: 10px;
        
        font-weight: 500;
        transition: all 0.3s ease;
    }

    .card-body a.btn:hover {
        transform: scale(1.05);
    }
</style>
</head>
<body>

<%@ include file="navBarSuccess.jsp" %>

<%
   String msg = (String)request.getAttribute("msg");
%>

<div class="container">
    <div class="card">
        <h3 class="card-header">
            <i class="bi bi-check-circle-fill me-2"></i><%= msg %>
        </h3>
        <div class="card-body d-flex justify-context-center">
            <a href="trackCourier.jsp" class="btn btn-success">
                <i class="bi bi-truck me-1"></i> Track Courier
            </a>
            <a href="bookCourier.jsp" class="btn btn-primary">
                <i class="bi bi-plus-circle me-1"></i> Book New Courier
            </a>
            <a href="customerDashboard.jsp" class="btn btn-secondary">
                <i class="bi bi-speedometer2 me-1"></i> Dashboard
            </a>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
