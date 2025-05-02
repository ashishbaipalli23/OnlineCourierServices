<%@ page import="com.ashi.BeansandDAOs.*" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Delivery Status</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%@ include file="navbarAgent.jsp" %>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card shadow">
                <div class="card-header bg-success text-white text-center">
                    <h5>🚚 Update Delivery Status</h5>
                </div>

                <div class="card-body">

                    <% if (request.getAttribute("msg") != null) { %>
                        <div class="alert alert-warning text-center">
                            <%= request.getAttribute("msg") %> <a href="agentDashBoard.jsp">go to DashBoard</a>
                        </div>
                    <% } %>

                    <% 
                       OrderBean assignedOrder = (OrderBean) request.getAttribute("assignedOrder");
                        if (assignedOrder != null) { 
                    %>
                        <form action="updateStatus" method="post">
                            <div class="mb-3">
                                <label for="orderId" class="form-label">Order ID</label>
                                <input type="number" class="form-control" name="orderId" id="orderId"
                                       value="<%= assignedOrder.getOrder_id() %>" readonly>
                            </div>
                            <div class="mb-3">
                                <label for="status" class="form-label">Select New Status</label>
                                <select class="form-select" name="status" id="status" required>
                                    <option value="Pending">Pending</option>
                                    <option value="In Transit">In Transit</option>
                                    <option value="Delivered">Delivered</option>
                                    <option value="Cancelled">Cancelled</option>
                                </select>
                            </div>
                            <div class="row">
                              <div class="col">
                              		<a href="agentDashBoard.jsp" class="btn btn-warning w-100">Back to Dashboard</a>
                              </div>
                              <div class="col">
                                <button type="submit" class="btn btn-primary w-100">Update Status</button>
                              </div>
                            </div>
                        </form>
                    <% } %>

                </div>

            </div>
        </div>
    </div>
</div>

</body>
</html>
