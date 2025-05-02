<%@page import="com.ashi.BeansandDAOs.CustomerBean"%>
<%@page import="com.ashi.BeansandDAOs.CourierBean"%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        .card-shadow {
            box-shadow: 0px 0px 15px rgba(0,0,0,0.1);
        }
        .fake-card {
            background: linear-
            gradient(135deg, #2b5876, #4e4376);
            color: white;
            border-radius: 15px;
            padding: 20px;
        }
        .fake-card span {
            font-size: 18px;
        }
    </style>
</head>
<body>
<%@ include file="navBarSuccess.jsp" %>
<%
    CourierBean courier = (CourierBean) session.getAttribute("courierBean");
    CustomerBean customer = (CustomerBean) session.getAttribute("customerBean"); // typo? maybe "customerBean"
    if (courier == null || customer == null) {
%>
    <div class="container mt-5">
        <div class="alert alert-danger text-center">
            <strong>Error:</strong> No order details found. Please book a courier first.
        </div>
    </div>
<%
    } else {
%>

<div class="container mt-5 col-md-6">
    <div class="card card-shadow">
        <div class="card-header bg-dark text-white text-center">
            <h4><i class="bi bi-credit-card-fill me-2"></i>Secure Payment</h4>
        </div>

        <div class="card-body">
            <!-- Fake Card Preview -->
            <div class="fake-card mb-4">
                <div class="d-flex justify-content-between text-dark">
                    <span><i class="bi bi-person-badge me-2"></i>Customer Name:</span>
                    <span><%= customer.getName() %></span>
                </div>
                <div class="d-flex justify-content-between mt-2 text-dark">
                    <span><i class="bi bi-box-seam me-2"></i>Order Type:</span>
                    <span><%= courier.getType() %></span>
                </div>
                <div class="d-flex justify-content-between mt-2 text-dark">
                    <span><i class="bi bi-geo-alt-fill me-2"></i>Pickup Location:</span>
                    <span> <%= courier.getPickupLocation() %> </span>
                </div>
                <div class="d-flex justify-content-between mt-2 text-dark">
                    <span><i class="bi bi-flag-fill me-2"></i>Destination:</span>
                    <span> <%= courier.getDestination() %> </span>
                </div>
                <div class="d-flex justify-content-between mt-2 text-dark">
                    <span><i class="bi bi-currency-rupee me-2"></i>Amount:</span>
                    <strong>₹ <%= courier.getCost() %></strong>
                </div>
            </div>

            <!-- Payment Form -->
            <form action="paymentHandler" method="post" onsubmit="showSpinner()">
                <input type="hidden" name="orderId" value="<%= courier.getCourier_id() %>">
                <input type="hidden" name="amount" value="<%= courier.getCost() %>">
                <input type="hidden" name="customerId" value="<%= courier.getCustomer_id() %>">

                <div class="mb-3">
                    <label class="form-label">Payment Method</label>
                    <select name="paymentMethod" class="form-control" required>
                        <option value="">-- Choose a method --</option>
                        <option value="Credit Card">💳 Credit Card</option>
                        <option value="Debit Card">🏦 Debit Card</option>
                        <option value="UPI">📱 UPI</option>
                        <option value="Net Banking">💻 Net Banking</option>
                        <option value="Cash on Delivery">🚚 Cash on Delivery</option>
                    </select>
                </div>

                <div class="d-grid">
                    <button type="submit" class="btn btn-success">
                        <i class="bi bi-lock-fill me-2"></i> Pay Securely
                    </button>
                </div>
                <div id="spinner" class="text-center mt-3 d-none">
                    <div class="spinner-border text-success" role="status"></div>
                    <p class="mt-2">Processing your payment...</p>
                </div>
            </form>
        </div>
    </div>
</div>

<%
    }
%>

<script>
    function showSpinner() {
        document.getElementById('spinner').classList.remove('d-none');
    }
</script>

</body>
</html>
