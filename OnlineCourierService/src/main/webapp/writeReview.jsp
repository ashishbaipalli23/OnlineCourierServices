<%@page import="com.ashi.BeansandDAOs.CustomerBean"%>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
    int orderId = Integer.parseInt(request.getParameter("orderId"));
    CustomerBean cBean = (CustomerBean) session.getAttribute("customerBean");
    int customerId = cBean.getCustomer_id();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Write Review</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: #f8f9fa;
        }

        .review-card {
            max-width: 650px;
            margin: auto;
            margin-top: 60px;
            border-radius: 15px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
        }

       .star-rating {
    direction: ltr;
    display: flex;
    flex-direction: row-reverse;
    justify-content: center;
    font-size: 2rem;
    gap: 5px;
}

.star-rating input[type="radio"] {
    display: none;
}

.star-rating label {
    color: #ccc;
    cursor: pointer;
    transition: color 0.2s;
}

.star-rating input[type="radio"]:checked ~ label,
.star-rating label:hover,
.star-rating label:hover ~ label {
    color: #ffc107;
}
       
        textarea {
            resize: vertical;
        }
    </style>
</head>
<body>
<%@ include file="navBarSuccess.jsp" %>

<div class="container">
    <div class="card review-card">
        <div class="card-header bg-primary text-white text-center rounded-top">
            <h4 class="mb-0 py-2">Write a Review for Order #<%= orderId %></h4>
        </div>
        <div class="card-body p-4">
            <form action="submitReview" method="post">
                <input type="hidden" name="orderId" value="<%= orderId %>">
                <input type="hidden" name="customerId" value="<%= customerId %>">

                <!-- Star Rating -->
                <div class="mb-4 text-center">
                    <label class="form-label mb-2 fw-semibold">Your Rating</label>
                   <div class="star-rating">
					    <% for (int i = 5; i >= 1; i--) { %>
					        <input type="radio" id="star<%= i %>" name="rating" value="<%= i %>">
					        <label for="star<%= i %>" title="<%= i %> star">&#9733;</label>
					    <% } %>
				  </div>
                   
                </div>

                <!-- Comments -->
                <div class="mb-3">
                    <label for="comments" class="form-label fw-semibold">Your Comments</label>
                    <textarea name="comments" class="form-control" rows="4" placeholder="Share your experience..." required></textarea>
                </div>

                <!-- Actions -->
                <div class="row">
                    <div class="col">
                         <a href="customerDashboard.jsp" class="btn btn-secondary w-100">Cancel</a>
                    </div>
                     <div class="col">
                        <button type="submit" class="btn btn-success w-100">Submit Review</button>
                     </div>
                    
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
