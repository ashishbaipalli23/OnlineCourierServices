<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.ashi.BeansandDAOs.ReviewBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Reviews</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%@ include file="navbarAgent.jsp" %>

<div class="container mt-5">
    <h3 class="text-center mb-4">📝 Customer Reviews</h3>

    <%
        List<ReviewBean> reviewList = (List<ReviewBean>) request.getAttribute("reviewList");

        if (reviewList == null || reviewList.isEmpty()) {
    %>
        <div class="alert alert-info text-center">No reviews available.</div>
    <%
        } else {
    %>
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>Order ID</th>
                    <th>Customer ID</th>
                    <th>Rating</th>
                    <th>Comments</th>
                    <th>Review Date</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (ReviewBean r : reviewList) {
                %>
                    <tr>
                        <td><%= r.getOrderId() %></td>
                        <td><%= r.getCustomerId() %></td>
                        <td><%= r.getRating() %></td>
                        <td> <%=  r.getComments() %> </td>
                        <td><%= r.getReviewDate() %></td>
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

</html>
