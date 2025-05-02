<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        background: linear-gradient(to right, #f0f4c3, #e1f5fe);
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }
    .dashboard-card {
        transition: transform 0.3s ease, box-shadow 0.3s ease;
        border-radius: 20px;
        background-color: #ffffff;
        border: none;
    }
    .dashboard-card:hover {
        transform: translateY(-5px);
        box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
    }
    .card-title {
        font-weight: 600;
        color: #2e7d32;
    }
    .card-icon {
        font-size: 2.5rem;
        color: #00796b;
    }
    .btn-outline-success, 
.btn-outline-primary, 
.btn-outline-danger, 
.btn-outline-warning {
    border: none !important;
    transition : 2s;
}
    
    
</style>
</head>
<body>

<%@ include file="navbarAdmin.jsp" %>

<div class="container mt-5">
    <h2 class="text-center text-success mb-4">Welcome <%= admin.getRole() %></h2>
    <div class="row g-4 justify-content-center">
        
        <!-- Add Delivery Staff -->
	    <div class="col-md-4 d-flex">
	    <div class="card dashboard-card h-100 w-100">
	        <div class="card-body d-flex flex-column text-center">
	            <div class="card-icon mb-2">➕</div>
	            <h5 class="card-title">Add Delivery Staff</h5>
	            <p>Add new delivery team members.</p>
	            <a href="addStaff.jsp" class="btn btn-outline-success mt-auto">Add Staff</a>
	        </div>
	    	</div>
		</div>
        

        <!-- View/Manage Staff -->
        <div class="col-md-4">
            <div class="card dashboard-card">
                <div class="card-body text-center">
                    <div class="card-icon mb-2">👥</div>
                    <h5 class="card-title">Manage Staff</h5>
                    <p>Update delivery staff info or reset their passwords.</p>
                    <a href="manageStaff" class="btn btn-outline-success mt-auto form-control">View Staff</a>
                </div>
            </div>
        </div>

        <!-- Assign Couriers -->
        <div class="col-md-4">
            <div class="card dashboard-card">
                <div class="card-body text-center">
                    <div class="card-icon mb-2">📤</div>
                    <h5 class="card-title">Assign Couriers</h5>
                    <p>Assign courier orders to available delivery staff.</p>
                    <a href="assignCourier" class="btn btn-outline-success mt-auto form-control">Assign Now</a>
                </div>
            </div>
        </div>

        <!-- Track Staff Performance -->
        <div class="col-md-4">
            <div class="card dashboard-card">
                <div class="card-body text-center">
                    <div class="card-icon mb-2">📈</div>
                    <h5 class="card-title">Staff Performance</h5>
                    <p>View delivery records and staff success rates.</p>
                    <a href="viewStaffPerformance" class="btn btn-outline-success mt-auto form-control">Track Performance</a>
                </div>
            </div>
        </div>

        <!-- Customer Reviews -->
		<div class="col-md-4">
		    <div class="card dashboard-card">
		        <div class="card-body text-center">
		            <div class="card-icon mb-2">⭐</div>
		            <h5 class="card-title">Customer Reviews</h5>
		            <p>Read ratings and feedback from customers.</p>
		            <a href="customerReviews" class="btn btn-outline-success mt-auto form-control">View Reviews</a>
		        </div>
		    </div>
		</div>


        <!-- Manage Profile -->
        <div class="col-md-4">
          
            <div class="card dashboard-card">
        <div class="card-body text-center">
                    <div class="card-icon mb-2">⚙️</div>
                    <h5 class="card-title">Manage Profile</h5>
                    <p>Update your profile and change your password.</p>
                    <a href="adminProfile.jsp" class="btn btn-outline-success mt-auto form-control">Update Profile</a>
                </div>
            </div>
        </div>

    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
