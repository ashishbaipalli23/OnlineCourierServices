<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Cancelled</title>

<!-- Bootstrap CDN for styling -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background-color: #f4f9fd;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    .card {
        border-radius: 20px;
        box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
    }

    .card-body {
        padding: 2rem;
    }

    .message-section h4 {
        color: #fff;
        margin-right: 20px;
    }

    .book-again-link {
        background-color: #ffffff;
        color: #17a2b8;
        padding: 8px 16px;
        text-decoration: none;
        border-radius: 8px;
        font-weight: 500;
        transition: all 0.3s ease-in-out;
    }

    .book-again-link:hover {
        background-color: #e0f7fa;
        color: #0d6efd;
    }
</style>
</head>
<body>
	<%@ include file="navBarSuccess.jsp" %>
	<%
	  String msg = (String)request.getAttribute("msg");
	%>
	<div class="container mt-5">
	    <div class="row justify-content-center">
	        <div class="col-md-6">
	            <div class="card bg-danger">
	                <div class="card-body text-center message-section">
	                    <h4><%= msg %></h4>
	                    <a href="bookCourier.jsp" class="book-again-link mt-3 d-inline-block">Book Again</a>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
</body>
</html>
