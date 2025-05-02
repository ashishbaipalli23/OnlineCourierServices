<%@ page import="java.time.LocalDate" %>
<%@ page import="com.ashi.BeansandDAOs.CustomerBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Courier</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .form-container {
            max-width: 600px;
            margin: 50px auto;
            background-color: white;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .form-container h3 {
            font-weight: bold;
        }
        .navbar-brand {
            font-weight: bold;
            font-size: large;
        }
    </style>
</head>
<body>

<%@ include file="navBarSuccess.jsp" %>

<div class="container form-container col-md-5">
    <h3 class="mb-4 text-center text-primary">
        <i class="bi bi-box-seam"></i> Book a Courier
    </h3>
    <form action="bookCourierService" method="post" class="p-4">
        <div class="mb-3">
            <label class="form-label"><i class="bi bi-geo-alt"></i> Pickup Location</label>
            <input type="text" class="form-control" name="pickup" required>
        </div>
        <div class="mb-3">
            <label class="form-label"><i class="bi bi-geo-alt-fill"></i> Destination</label>
            <input type="text" class="form-control" name="destination" required>
        </div>
        <div class="mb-3">
            <label class="form-label"><i class="bi bi-weight"></i> Weight (kg)</label>
            <input type="number" step="0.01" class="form-control" name="weight"  min="0.5" max="30" required>
        </div>
        <div class="mb-3">
            <label class="form-label"><i class="bi bi-box"></i> Type</label>
            <select class="form-control" name="type">
                <option value="Document">Document</option>
                <option value="Parcel">Parcel</option>
                <option value="Fragile">Fragile</option>
            </select>
        </div>
           <div class="row">
              <div class="col">
                  <a href="customerDashboard.jsp" class="btn btn-warning form-control">Go Back</a>
              </div>
              <div class="col">
              	  <button type="submit" class="btn btn-success form-control">Book Courier</button>
              </div>
           </div>
      
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
