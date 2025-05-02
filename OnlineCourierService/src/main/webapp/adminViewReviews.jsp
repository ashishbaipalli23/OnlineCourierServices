<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.ashi.BeansandDAOs.ReviewBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Customer Reviews</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/dataTables.bootstrap5.min.css">

    <!-- jQuery and DataTables JS -->
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>

    <style>
        body {
            background-color: #f8f9fa;
        }
        h3 {
            color: #343a40;
        }
        .table-container {
            background: white;
            border-radius: 12px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
            padding: 20px;
        }
        .table thead th {
            vertical-align: middle;
        }
        .btn-back {
            margin-top: 30px;
        }
        .dataTables_wrapper .dataTables_filter input {
            border-radius: 8px;
            padding: 5px 10px;
            border: 1px solid #ced4da;
        }
        .dataTables_wrapper .dataTables_length select {
            border-radius: 6px;
            padding: 4px;
        }
    </style>
</head>
<body>

<%@ include file="navbarAdmin.jsp" %>

<div class="container mt-5">
    <h3 class="text-center mb-4">⭐ All Customer Reviews</h3>

    <%
        List<ReviewBean> reviewList = (List<ReviewBean>) request.getAttribute("reviewList");
        if (reviewList == null || reviewList.isEmpty()) {
    %>
        <div class="alert alert-info text-center">No reviews found.</div>
    <%
        } else {
    %>
        <div class="table-container">
            <div class="table-responsive">
                <table id="reviewTable" class="table table-bordered table-striped table-hover align-middle mb-0">
                    <thead class="table-dark">
                        <tr>
                            <th>Review ID</th>
                            <th>Customer ID</th>
                            <th>Order ID</th>
                            <th>Staff ID</th>
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
                                <td><%= r.getReviewId() %></td>
                                <td><%= r.getCustomerId() %></td>
                                <td><%= r.getOrderId() %></td>
                                <td><%= r.getStaffId() %></td>
                                <td><%= r.getRating() %></td>
                                <td><%= r.getComments() %></td>
                                <td><%= r.getReviewDate() %></td>
                            </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    <%
        }
    %>

    <div class="text-center btn-back">
        <a href="adminDashBoard.jsp" class="btn btn-warning px-4 py-2 shadow-sm">← Back to Dashboard</a>
    </div>
</div>

<!-- DataTable Initialization -->
<script>
    $(document).ready(function () {
        $('#reviewTable').DataTable({
            pageLength: 10,
            order: [[6, 'desc']],
            columnDefs: [
                { orderable: false, targets: [5] }
            ],
            language: {
                search: "_INPUT_",
                searchPlaceholder: "Search reviews..."
            }
        });
    });
</script>

</body>
</html>
