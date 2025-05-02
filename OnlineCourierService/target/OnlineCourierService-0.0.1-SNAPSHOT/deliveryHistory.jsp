<%@ page import="java.util.*, com.ashi.BeansandDAOs.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delivery History</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<jsp:include page="navbarAgent.jsp" />

<div class="container mt-5">
    <h3 class="mb-4 text-center">📜 Delivery History</h3>

    <%
        List<OrderBean> history = (List<OrderBean>) request.getAttribute("history");

        if (history == null || history.isEmpty()) {
    %>
        <div class="alert alert-info text-center">No deliveries completed yet.</div>
    <%
        } else {
    %>
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>Order ID</th>
                    <th>Customer ID</th>
                    <th>Booking Date</th>
                    <th>Delivery Date</th>
                    <th>Status</th>
                  
                </tr>
            </thead>
            <tbody>
                <%
                    for (OrderBean o : history) {
                %>
                    <tr>
                        <td> <%=  o.getOrder_id()  %> </td>
                        <td> <%= o.getCustomer_id() %> </td>
                        <td> <%= o.getOrder_date()  %> </td>
                        <td> <%= o.getDelivery_date()  %> </td>
                        <td><%= o.getStatus() %></td>
                        
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    <%
        }
    %>
</div>

</body>
</html>
