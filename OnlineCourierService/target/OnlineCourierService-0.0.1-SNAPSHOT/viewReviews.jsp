<%@ page import="com.ashi.BeansandDAOs.ReviewBean" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Reviews</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background-color: #f4f6f9;
            font-family: 'Segoe UI', sans-serif;
        }

        .review-card {
            border-radius: 15px;
            box-shadow: 0 6px 16px rgba(0, 0, 0, 0.08);
            background-color: #ffffff;
            transition: transform 0.2s;
        }

        .review-card:hover {
            transform: translateY(-3px);
        }

        .star {
            color: #ffc107;
            font-size: 1.4rem;
        }

        .star-muted {
            color: #e4e5e9;
        }

        .review-header {
            font-weight: 600;
            color: #212529;
        }

        .review-date {
            font-size: 0.85rem;
            color: #6c757d;
        }

        .review-comment {
            font-size: 1rem;
            color: #495057;
        }

        .icon-left {
            font-size: 1.3rem;
            color: #0d6efd;
            margin-right: 10px;
        }

        .review-title {
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 8px;
        }
    </style>
</head>
<body>
<%@ include file="navBarSuccess.jsp" %>

<div class="container mt-5">
    <div class="text-center mb-4 review-title">
        <i class="bi bi-chat-square-quote icon-left"></i>
        <h3 class="mb-0">My Reviews</h3>
    </div>

    <%
        List<ReviewBean> reviews = (List<ReviewBean>) request.getAttribute("reviews");
        if (reviews == null || reviews.isEmpty()) {
    %>
        <div class="alert alert-warning text-center">
            <i class="bi bi-info-circle"></i> No reviews found.
        </div>
    <%
        } else {
            for (ReviewBean review : reviews) {
    %>
        <div class="card mb-4 review-card">
            <div class="card-body">
                <div class="d-flex justify-content-between mb-2">
                    <div class="review-header">
                        <i class="bi bi-box-seam"></i> Order ID: <%= review.getOrderId() %>
                    </div>
                    <div class="review-date">
                      review Date: <i class="bi bi-calendar-event"></i> <%= review.getReviewDate() %>
                    </div>
                </div>
                <div class="mb-2">
                   Rating:
                    <% for (int i = 1; i <= review.getRating(); i++) { %>
                        <i class="bi bi-star-fill star"></i>
                    <% } %>
                    <% for (int i = review.getRating() + 1; i <= 5; i++) { %>
                        <i class="bi bi-star star star-muted"></i>
                    <% } %>
                </div>
                <p class="review-comment">
                  FeedBack: <br>
                    <i class="bi bi-quote"></i> <%= review.getComments() %>
                </p>
            </div>
        </div>
    <%
            }
        }
    %>
</div>

</body>
</html>
