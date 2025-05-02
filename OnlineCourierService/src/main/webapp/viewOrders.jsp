<%@ page import="com.ashi.BeansandDAOs.*,java.util.*" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order History</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="navBarSuccess.jsp" %>

<div class="container mt-5 mb-5 shadow-sm">
  <h3 class="mb-4 text-center text-primary">Your Past Orders</h3>
  <table class="table table-bordered table-hover table-striped align-middle">
    <thead class="table-primary text-center">
      <tr>
        <th>Order ID</th>
        <th>Order Date</th>
        <th>Pickup</th>
        <th>Destination</th>
        <th>Weight (kg)</th>
        <th>Type</th>
        <th>Cost (₹)</th>
        <th>Expected Delivery</th>
        <th>Delivery Status</th>
        <th>Payment (₹)</th>
        <th>Method</th>
        <th>Payment Date</th>
        <th>Payment Status</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <%
        List<OrderDetailsBean> list = (List<OrderDetailsBean>)request.getAttribute("orderList");
        if (list != null && !list.isEmpty()) {
          for (OrderDetailsBean order : list) {
            String deliveryStatus = order.getOrderStatus();
            String paymentStatus = order.getPaymentStatus();
            boolean reviewEnabled = "Delivered".equalsIgnoreCase(deliveryStatus);
            
      %>
      <tr class="text-center">
        <td><%= order.getOrderId() %></td>
        <td><%= order.getOrderDate() %></td>
        <td><%= order.getPickupLocation() %></td>
        <td><%= order.getDestination() %></td>
        <td><%= order.getWeight() %></td>
        <td><%= order.getType() %></td>
        <td>₹<%= order.getCost() %></td>
        <td><%= order.getExpectedDelivery() %></td>

        <!-- Delivery Status Badge -->
        <td>
          <span class="badge rounded-pill bg-<%= 
              "Delivered".equalsIgnoreCase(deliveryStatus) ? "success" : 
              "In Transit".equalsIgnoreCase(deliveryStatus) ? "info" : 
              "danger" %>">
            <%= deliveryStatus %>
          </span>
        </td>

        <td>₹<%= order.getAmount() %></td>
        <td><%= order.getPaymentMethod() %></td>
        <td><%= order.getPaymentDate() %></td>

        <!-- Payment Status Badge -->
        <td>
          <span class="badge rounded-pill bg-<%= 
              "Paid".equalsIgnoreCase(paymentStatus) ? "success" : 
              "Pending".equalsIgnoreCase(paymentStatus) ? "warning" : 
              "danger" %>">
            <%= paymentStatus %>
          </span>
        </td>

        <!-- Write Review Button -->
		<td>
		  <form action="writeReview.jsp" method="post">
		    <input type="hidden" name="orderId" value="<%= order.getOrderId() %>">
		    <button type="submit" class="btn btn-primary btn-sm form-control"
		      <%= (reviewEnabled && !order.isReviewExist()) ? "" : "disabled" %>>
		      Write Review
		    </button>
		  </form>
		</td>
        
      </tr>
      <%
          }
        } else {
      %>
      <tr><td colspan="14" class="text-center">No past orders found.</td></tr>
      <%
        }
      %>
    </tbody>
  </table>

  <div class="text-center mt-4 ">
    <a href="customerDashboard.jsp" class="btn btn-warning mb-2">Back to Dashboard</a>
  </div>
</div>

</body>
</html>
