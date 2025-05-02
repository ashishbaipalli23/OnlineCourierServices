<%@page import="com.ashi.BeansandDAOs.CustomerBean"%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Customer Dashboard</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
<style>
     body {
        background: linear-gradient(to right, #f0f4c3, #e1f5fe);
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

  .dashboard-container {
    margin-top: 40px;
  }

  .card {
    border-radius: 20px;
    padding: 20px;
    border: 1px solid #ddd;
    background: linear-gradient(145deg, #ffffff, #f4f4f4);
    transition: transform 0.3s ease, box-shadow 0.3s ease, border-color 0.3s ease;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
  }

  .card:hover {
    transform: translateY(-8px);
    box-shadow: 0 12px 25px rgba(0, 0, 0, 0.15);
    border-color: #0d6efd;
  }

  .card i {
    transition: transform 0.3s ease, color 0.3s ease;
  }

  .card:hover i {
    transform: scale(1.2);
    color: #0d6efd;
  }

  .card h5 {
    margin-top: 15px;
    font-weight: 600;
    color: #333;
  }

  .card p {
    font-size: 0.95rem;
    color: #666;
  }

  .btn {
    margin-top: 10px;
    border-radius: 25px;
    font-weight: 500;
  }
</style>

  
</head>
<body>
 
 <%@ include file="navBarSuccess.jsp" %>

  <!-- Dashboard Features -->
  <div class="container dashboard-container">
    <div class="row g-4 mb-3">

      <!-- Book Courier -->
      <div class="col-md-6 col-lg-4">
        <div class="card p-4 text-center">
          <i class="bi bi-box-seam display-4 text-primary"></i>
          <h5 class="mt-3">Book a Courier</h5>
          <p>Schedule a courier pickup to send your parcel.</p>
          <a href="bookCourier" class="btn btn-primary">Book Now</a>
        </div>
      </div>

      <!-- Track Courier -->
      <div class="col-md-6 col-lg-4">
        <div class="card p-4 text-center">
          <i class="bi bi-truck display-4 text-success"></i>
          <h5 class="mt-3">Track Courier</h5>
          <p>Check status of your shipment using tracking ID.</p>
          <a href="trackCourier.jsp" class="btn btn-success">Track</a>
        </div>
      </div>

      <!-- View Orders -->
      <div class="col-md-6 col-lg-4">
        <div class="card p-4 text-center">
          <i class="bi bi-card-list display-4 text-warning"></i>
          <h5 class="mt-3">Past Orders</h5>
          <p>Review your past courier orders and their status.</p>
          <a href="viewOrders" class="btn btn-warning">View</a>
        </div>
      </div>

      <!-- Update Profile -->
      <div class="col-md-6 col-lg-4">
        <div class="card p-4 text-center">
          <i class="bi bi-person-circle display-4 text-info"></i>
          <h5 class="mt-3">Update Profile</h5>
          <p>View or update your profile information.</p>
          <a href="editProfile" class="btn btn-info">Update</a>
        </div>
      </div>

      <!-- Payment History -->
      <div class="col-md-6 col-lg-4">
        <div class="card p-4 text-center">
          <i class="bi bi-credit-card display-4 text-dark"></i>
          <h5 class="mt-3">Payment History</h5>
          <p>View your past payment transactions.</p>
          <a href="paymentHistory" class="btn btn-dark">Payments</a>
        </div>
      </div>

      <!-- Review Section -->
      <div class="col-md-6 col-lg-4">
        <div class="card p-4 text-center">
          <i class="bi bi-star-fill display-4 text-secondary"></i>
          <h5 class="mt-3">Your Reviews</h5>
          <p>view submitted reviews.</p>
          <a href="viewReviews" class="btn btn-secondary">Reviews</a>
        </div>
      </div>

    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
