<%@ page import="java.util.List" %>
<%@ page import="com.ashi.BeansandDAOs.OrderBean" %>
<%@ page import="com.ashi.BeansandDAOs.DeliveryAgentBean" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assign Courier</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <%@ include file="navbarAdmin.jsp" %>

    <%
        String msg = (String) request.getAttribute("msg");
        List<OrderBean> unassignedOrders = (List<OrderBean>) request.getAttribute("unassignedOrders");
        List<DeliveryAgentBean> agents = (List<DeliveryAgentBean>) request.getAttribute("agents");
    %>

    <div class="container my-5">
        <h2 class="text-center mb-4">Assign Orders to Delivery Agents</h2>

       <!-- Show session message -->
<% if (msg != null) { %>
    <div class="alert alert-info alert-dismissible fade show text-center w-50" role="alert">
        <strong>Info:</strong> <%= msg %>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
<% } %>
       
        <div class="card shadow-sm">
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-striped align-middle">
                        <thead class="table-primary">
                            <tr class="text-center">
                                <th>Order ID</th>
                                <th>Customer ID</th>
                                <th>Pickup Location</th>
                                <th>Destination</th>
                                <th>Order Date</th>
                                <th>Assign Agent</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% if (unassignedOrders != null && !unassignedOrders.isEmpty()) { 
                                for (OrderBean order : unassignedOrders) { %>
                                <form action="assignCourierToAgent" method="post">
                                    <tr class="text-center">
                                        <td><%= order.getOrder_id() %></td>
                                        <td><%= order.getCustomer_id() %></td>
                                        <td><%= order.getCourier().getPickupLocation() %></td>
                                        <td><%= order.getCourier().getDestination() %></td>
                                        <td><%= order.getOrder_date() %></td>
                                        <td>
                                            <select name="staffId" class="form-select" required>
                                                <option value="">Select Agent</option>
                                                <% if (agents != null && !agents.isEmpty()) {
                                                    for (DeliveryAgentBean agent : agents) { %>
                                                        <option value="<%= agent.getStaffId() %>">
                                                            <%= agent.getName() %> (ID: <%= agent.getStaffId() %>)
                                                        </option>
                                                <% } } else { %>
                                                    <option disabled>No agents available</option>
                                                <% } %>
                                            </select>
                                        </td>
                                        <td>
                                            <input type="hidden" name="orderId" value="<%= order.getOrder_id() %>">
                                            <button type="submit" class="btn btn-success btn-sm">Assign</button>
                                        </td>
                                    </tr>
                                </form>
                            <% } 
                            } else { %>
                                <tr>
                                    <td colspan="7" class="text-center text-muted py-4">
                                        No unassigned orders available at the moment.
                                    </td>
                                </tr>
                            <% } %>
                        </tbody>
                     
                    </table>
                       <a href="adminDashBoard.jsp" class="btn btn-warning">Back to DashBoard</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
