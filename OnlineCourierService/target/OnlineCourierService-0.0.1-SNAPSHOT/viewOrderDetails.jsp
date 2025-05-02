<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ashi.BeansandDAOs.OrderBean, com.ashi.BeansandDAOs.CourierBean, com.ashi.BeansandDAOs.CustomerBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .equal-height {
            display: flex;
            flex-direction: column;
            height: 100%;
        }
    </style>
</head>
<body>

<%@ include file="navbarAgent.jsp" %>

<div class="container mt-5">
    <%
        OrderBean order = (OrderBean) request.getAttribute("orderDetails");

        if (order != null) {
            CourierBean courier = order.getCourier();
            CustomerBean customer = order.getCustomer();
    %>

    <div class="card shadow-lg rounded">
        <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
            <h4 class="mb-0">📋 Order Details</h4>
            <span class="badge bg-light text-dark fs-6">#<%= order.getOrder_id() %></span>
        </div>

        <div class="card-body">
            <div class="row text-start">

                <!-- Order Info -->
                <div class="col-md-4 mb-3 d-flex">
                    <div class="equal-height p-3 border rounded bg-light shadow-sm w-100">
                        <h6 class="text-primary">📦 Order Info</h6>
                        <p><strong>Order ID:</strong> <%= order.getOrder_id() %></p>
                        <p><strong>Order Date:</strong> <%= order.getOrder_date() %></p>
                        <p><strong>Status:</strong> 
                            <span class="badge bg-info text-dark"><%= order.getStatus() %></span>
                        </p>
                    </div>
                </div>

                <!-- Courier Info -->
                <div class="col-md-4 mb-3 d-flex">
                    <div class="equal-height p-3 border rounded bg-light shadow-sm w-100">
                        <h6 class="text-success">🚚 Courier Info</h6>
                        <p><strong>Courier ID:</strong> <%= courier.getCourier_id() %></p>
                        <p><strong>Pickup:</strong> <%= courier.getPickupLocation() %></p>
                        <p><strong>Destination:</strong> <%= courier.getDestination() %></p>
                        <p><strong>Weight:</strong> <%= courier.getWeight() %> kg</p>
                        <p><strong>Cost:</strong> $<%= courier.getCost() %></p>
                        <p><strong>Excepted Delivery:</strong> 
                            <span class="badge bg-success">
                                <%= courier.getExpected_delivery() != null ? courier.getExpected_delivery() : "Pending" %>
                            </span>
                        </p>
                    </div>
                </div>

                <!-- Customer Info -->
                <div class="col-md-4 mb-3 d-flex">
                    <div class="equal-height p-3 border rounded bg-light shadow-sm w-100">
                        <h6 class="text-info">👤 Customer Info</h6>
                        <p><strong>Name:</strong> <%= customer.getName() %></p>
                        <p><strong>Phone:</strong> <%= customer.getPhone() %></p>
                    </div>
                </div>

            </div>
        </div>

        <div class="card-footer  bg-light">
            <a href="agentDashBoard.jsp" class="btn btn-warning">
                ⬅ Back to DashBoard
            </a>
        </div>
    </div>

    <%
        } else {
    %>
        <div class="alert alert-warning text-center">Order details not found. <a href="agentDashBoard.jsp">Back to Dashboard</a> </div>
    <%
        }
    %>
</div>

</body>
</html>
