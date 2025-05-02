<%@ page import="com.ashi.BeansandDAOs.OrderDetailsBean" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Track Courier</title>
  
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  
  <!-- Bootstrap Icons -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

  <style>
    body {
      background: #f8f9fa;
    }
    .card h3, .card h4 {
      display: flex;
      align-items: center;
      gap: 0.5rem;
    }
    .form-label::after {
      content: "*";
      color: red;
      margin-left: 0.2rem;
    }
  </style>
</head>
<body>

<%@ include file="navBarSuccess.jsp" %>

<div class="container mt-5">
  <div class="row justify-content-center">
    
    <!-- Left: Form -->
    <div class="col-md-5 mb-4">
      <div class="card p-4 shadow-sm">
        <h3 class="mb-4 text-primary">
          <i class="bi bi-search"></i> Track Your Courier
        </h3>
        <form action="trackCourier" method="post" class="p-4">
          <div class="mb-3">
            <label for="orderId" class="form-label">Enter Order ID</label>
            <input type="text" name="orderId" class="form-control " required />
          </div>
          <div class="row">
              <div class="col">
                  <a href="customerDashboard.jsp" class="btn btn-warning  w-100">Back</a>
              </div>
              <div class="col">
                 <button type="submit" class="btn btn-success w-100">
            <i class="bi bi-search"></i> Track
          </button>
              </div>
          </div>
        </form>
      </div>
    </div>

    <!-- Right: Tracking Info -->
    <div class="col-md-6">
      <%
        OrderDetailsBean order = (OrderDetailsBean) request.getAttribute("order");
        String msg = (String) request.getAttribute("msg");
        if (order != null) {
      %>
      <div class="card p-4 shadow-sm border-start border-3 border-success">
        <h4 class="mb-3 text-success">
          <i class="bi bi-truck"></i> Tracking Details
        </h4>
        <ul class="list-group list-group-flush">
          <li class="list-group-item"><strong><i class="bi bi-hash"></i> Order ID:</strong> <%= order.getOrderId() %></li>
          <li class="list-group-item"><strong><i class="bi bi-geo-alt"></i> Pickup:</strong> <%= order.getPickupLocation() %></li>
          <li class="list-group-item"><strong><i class="bi bi-flag"></i> Destination:</strong> <%= order.getDestination() %></li>
          <li class="list-group-item">
            <strong><i class="bi bi-box-seam"></i> Status:</strong>
            <span class="badge bg-<%= 
              "Delivered".equalsIgnoreCase(order.getOrderStatus()) ? "success" : 
              "In Transit".equalsIgnoreCase(order.getOrderStatus()) ? "info" : 
              "danger" %>">
              <%= order.getOrderStatus() %>
            </span>
          </li>
          <li class="list-group-item"><strong><i class="bi bi-calendar-event"></i> Expected Delivery:</strong> <%= order.getExpectedDelivery() %></li>
        </ul>
      </div>
      <%
        } else if (msg != null) {
      %>
      <div class="alert alert-danger mt-3">
        <i class="bi bi-exclamation-circle"></i> <%= msg %>
      </div>
      <%
        }
      %>
    </div>
  </div>
</div>

</body>
</html>
