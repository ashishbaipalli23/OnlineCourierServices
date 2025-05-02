<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.ashi.BeansandDAOs.OrderBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Assigned Order</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
   <style>
    body {
        background-color: #f9f9f9;
        min-height: 100vh;
    }
    .order-card {
    
        min-height: 300px;        /* Increased height */
        border-radius: 16px;
        box-shadow: 0 4px 16px rgba(0,0,0,0.1);
        transition: transform 0.3s ease;
        position: relative;
        margin: 0 auto;           /* Centering the card */
        padding: 20px;
    }
    .order-card:hover {
        transform: translateY(-8px);
    }
    .order-status {
        position: absolute;
        top: 15px;
        right: 20px;
        font-size: 0.9rem;
    }
    .card-body {
        font-size: 1rem;
    }
    .card-footer {
        background-color: #fff;
        border-top: none;
    }
</style>
   
</head>
<body>

<%@ include file="navbarAgent.jsp" %>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md d-flex justify-content-center">
            <%
                List<OrderBean> orders = (List<OrderBean>) request.getAttribute("assignedOrders");
                if (orders != null && !orders.isEmpty()) {
                    OrderBean order = orders.get(0); // Display only the first order
            %>
                <div class="card order-card p-3 col-md-6">
                    <div class="order-status">
                        <span class="badge bg-secondary px-3 py-2"><%= order.getStatus() %></span>
                    </div>
                    <div class="card-body d-flex flex-column justify-content-between">
                        <div>
                            <h5 class="text-primary mb-3">📦 Order #<%= order.getOrder_id() %></h5>
                            <p>👤 <strong>Customer:</strong> <%= order.getCustomer_id() %></p>
                            <p>📮 <strong>Courier:</strong> <%= order.getCourier_id() != 0 ? order.getCourier_id() : "Not Assigned" %></p>
                        </div>
                        <div>
                            <p>📅 <strong>Ordered On:</strong> <%= order.getOrder_date() %></p>
                            <p>
                                🚚 <strong>Delivery:</strong>
                                <span class="badge bg-success">
                                    <%= order.getDelivery_date() != null ? order.getDelivery_date() : "Pending" %>
                                </span>
                            </p>
                        </div>
                    </div>
                    
                    <div class="row card-footer ">
                       <div class="col">
                             <a href="agentDashBoard.jsp" class="btn btn-warning btn-sm w-100 ">back</a>
                       </div>
                       <div class="col">
                             <a href="viewOrderDetails?id=<%= order.getOrder_id() %>" class="btn btn-sm btn-success w-100">View Details</a>
                       </div>
                    
                    
                    </div>
                </div>
            <%
                } else {
            %>
                <div class="alert alert-warning text-center w-100">No assigned order found.</div>
            <%
                }
            %>
        </div>
    </div>
</div>

</body>
</html>
