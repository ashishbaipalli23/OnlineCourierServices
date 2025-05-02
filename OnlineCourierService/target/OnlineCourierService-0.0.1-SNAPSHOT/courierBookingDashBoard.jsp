<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ashi.BeansandDAOs.CourierBean" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Courier Dashboard</title>

<!-- Bootstrap CSS and Icons -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

<style>
  body {
    background-color: #f8f9fa;
  }
  .dashboard-card {
    max-width: 700px;
    margin: auto;
  }
  .order-item i {
    width: 25px;
    color: #0d6efd;
  }
  .action-btns a {
    min-width: 180px;
  }
</style>
</head>
<body>

<%@ include file="navBarSuccess.jsp" %>


<%
   String msg  = (String)request.getAttribute("msg");
   //CourierBean cBean = (CourierBean) request.getAttribute("courierBean");
   CourierBean cBean = (CourierBean) session.getAttribute("courierBean");

   if(msg == null || cBean == null){ // 
	 response.sendRedirect("login.jsp");
	 return;
   }

   SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm a");
%>

<!-- Alert Message -->
<div class="container mt-4 d-flex justify-content-center">
  <div class="alert alert-success alert-dismissible fade show w-50" role="alert">
    <i class="bi bi-check-circle-fill me-2"></i> <%= msg %>
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
  </div>
</div>

<!-- Dashboard Card -->
<div class="container mt-4 mb-5">
  <div class="card shadow dashboard-card p-4">
    <h3 class="card-title text-center text-info mb-3">
      <i class="bi bi-receipt-cutoff me-2"></i>Courier Order Summary
    </h3>
    <hr>

    <!-- Order Details -->
    <div class="mb-3 order-item"><i class="bi bi-geo-alt-fill"></i> <strong>Pickup Location:</strong> <%= cBean.getPickupLocation() %></div>
    <div class="mb-3 order-item"><i class="bi bi-flag-fill"></i> <strong>Destination:</strong> <%= cBean.getDestination() %></div>
    <div class="mb-3 order-item"><i class="bi bi-box-seam"></i> <strong>Weight:</strong> <%= cBean.getWeight() %> kg</div>
    <div class="mb-3 order-item"><i class="bi bi-tag-fill"></i> <strong>Type:</strong> <%= cBean.getType() %></div>
    <div class="mb-3 order-item"><i class="bi bi-currency-rupee"></i> <strong>Cost:</strong> ₹<%= cBean.getCost() %></div>
    <div class="mb-3 order-item"><i class="bi bi-calendar-plus"></i> <strong>Booking Date:</strong> <%= sdf.format(cBean.getBooking_date()) %></div>
    <div class="mb-4 order-item"><i class="bi bi-truck"></i> <strong>Expected Delivery:</strong> <%= sdf.format(cBean.getExpected_delivery()) %></div>

    <hr class="mb-4">

    <!-- Action Buttons -->
    
    <div class="d-flex flex-column flex-md-row justify-content-center gap-2 action-btns">
      <a href="editOrder" class="btn btn-warning btn-sm">
        <i class="bi bi-pencil-square me-2"></i> Edit Order
      </a>
      <a href="cancelOrder?orderId=<%= cBean.getCourier_id() %>" onclick="return confirm('are you sure want to cancel ?')" class="btn btn-danger btn-sm">
        <i class="bi bi-x-circle-fill me-2"></i> Cancel Order
      </a>
      <a href="paymentPage" class="btn btn-success btn-sm">
        <i class="bi bi-credit-card-fill me-2"></i> Go to Payment
      </a>
    </div>
  </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
