<%@page import="com.ashi.BeansandDAOs.CourierBean"%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Edit Order</title>

  <!-- Bootstrap & Icons -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

  <style>
    body {
      background-color: #f8f9fa;
    }
    .card {
      border-radius: 15px;
    }
    .card-header {
      background-color: #0d6efd;
      color: white;
      border-radius: 15px 15px 0 0;
    }
    .form-label i {
      color: #0d6efd;
      margin-right: 5px;
    }
  </style>
</head>
<body>

<%@ include file="navBarSuccess.jsp" %>

<%
 
  CourierBean cBean = (CourierBean)session.getAttribute("courierBean");

  if (cBean == null) {
    response.sendRedirect("login.jsp");
    return;
  }
%>



<!-- Card Form -->
<div class="container d-flex justify-content-center mt-5 mb-5">
  <div class="card shadow-lg col-md-6">
    <div class="text-center mt-5">
      <h4 class="text-primary"><i class="bi bi-box-seam-fill me-2"></i> Edit Your Courier</h4>
    </div>
    <div class="card-body">
      <form action="editOrderHandler" method="post" class="px-4">
        <div class="mb-3">
          <label class="form-label"><i class="bi bi-geo-alt"></i>Pickup Location</label>
          <input type="text" class="form-control" name="pickup" value="<%= cBean.getPickupLocation() %>" required>
        </div>
        <div class="mb-3">
          <label class="form-label"><i class="bi bi-flag-fill"></i>Destination</label>
          <input type="text" class="form-control" name="destination" value="<%= cBean.getDestination() %>" required>
        </div>
        <div class="mb-3">
          <label class="form-label"><i class="bi bi-weight"></i>Weight (kg)</label>
          <input type="number" step="0.01" class="form-control" name="weight" value="<%= cBean.getWeight() %>" required>
        </div>
        <div class="mb-4">
          <label class="form-label"><i class="bi bi-box"></i>Type</label>
          <select class="form-control" name="type" required>
            <option value="Document" <%= cBean.getType().equals("Document") ? "selected" : "" %>>Document</option>
            <option value="Parcel" <%= cBean.getType().equals("Parcel") ? "selected" : "" %>>Parcel</option>
            <option value="Fragile" <%= cBean.getType().equals("Fragile") ? "selected" : "" %>>Fragile</option>
          </select>
        </div>

        <!-- Hidden field -->
        <input type="hidden" name="courierId" value="<%= cBean.getCourier_id() %>">

        <div class="row">
          <div class="col">
            <a href="courierBookingDashBoard.jsp" class="btn btn-warning form-control">Go Back</a>
          </div>
          <div class="col">
            <button type="submit" class="btn btn-primary form-control">Update Courier</button>
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
