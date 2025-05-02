<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agent Dashboard</title>
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
        color: #333;
    }
    .card-icon {
        font-size: 2.5rem;
    }
   
    .btn-outline-dark {
         border: none !important;
    }
   
</style>
</head>
<body>

<%@ include file="navbarAgent.jsp" %>

<div class="container mt-5">
    <h2 class="text-center text-primary mb-4">Welcome Agent!</h2>
    <div class="row g-4 justify-content-center">
        
        <!-- View Assigned Courier Orders -->
        <div class="col-md-4">
            <div class="card dashboard-card">
                <div class="card-body text-center">
                    <div class="card-icon mb-2">📦</div>
                    <h5 class="card-title">Assigned Courier Orders</h5>
                    <p>See all courier bookings assigned and filter by status.</p>
                    <a href="viewAssignedOrders" class="btn btn-outline-dark form-control">View Orders</a>
                </div>
            </div>
        </div>
        
         <!-- View Order Details -->
        <div class="col-md-4 mt-4">
            <div class="card dashboard-card">
                <div class="card-body text-center">
                    <div class="card-icon mb-2">🔍</div>
                    <h5 class="card-title">View Order Details</h5>
                    <p>Access customer info, address, cost, and delivery info.</p>
                    <a href="viewOrderInfo.jsp" class="btn btn-outline-dark form-control">View Details</a>
                </div>
            </div>
        </div>
        
        
        

        <!-- Update Delivery Status -->
        <div class="col-md-4">
            <div class="card dashboard-card">
                <div class="card-body text-center">
                    <div class="card-icon mb-2">🚚</div>
                    <h5 class="card-title">Update Delivery Status</h5>
                    <p>Change courier status or add delivery remarks.</p>
                    <a href="updateStatus" class="btn btn-outline-dark form-control">Update Status</a>
                </div>
            </div>
        </div>

       
     <!-- Review by Customer -->
	<div class="col-md-4">
	    <div class="card dashboard-card">
	        <div class="card-body text-center">
	            <div class="card-icon mb-2">📝</div>
	            <h5 class="card-title">Review by Customer</h5>
	            <p>View customer feedback on delivered orders.</p>
	            <a href="ViewAgentReviews" class="btn btn-outline-dark form-control">View Reviews</a>
	        </div>
	    </div>
	</div>
     
       
       
        <!-- View Delivery History -->
        <div class="col-md-4  mt-4">
            <div class="card dashboard-card">
                <div class="card-body text-center">
                    <div class="card-icon mb-2">📜</div>
                    <h5 class="card-title">Delivery History</h5>
                    <p>completed deliveries and performance history.</p>
                    <a href="deliveryHistory" class="btn btn-outline-dark form-control">View History</a>
                </div>
            </div>
        </div>

        <!-- Manage Profile -->
        <div class="col-md-4  mt-4">
            <div class="card dashboard-card">
                <div class="card-body text-center">
                    <div class="card-icon mb-2">👤</div>
                    <h5 class="card-title">Manage Profile</h5>
                    <p>Update your profile and change password securely.</p>
                    <a href="agentProfile" class="btn btn-outline-dark form-control">Manage</a>
                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>
