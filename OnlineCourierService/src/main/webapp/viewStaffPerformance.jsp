<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.ashi.BeansandDAOs.StaffPerformanceBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Staff Performance</title>

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
        .container {
            margin-top: 50px;
        }
        .card {
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        }
        h3 {
            color: #343a40;
        }
    </style>
</head>
<body>

<%@ include file="navbarAdmin.jsp" %>

<div class="container">
    <h3 class="text-center mb-4">🚚 Staff Performance Overview</h3>

    <%
        List<StaffPerformanceBean> staffList = (List<StaffPerformanceBean>) request.getAttribute("staffPerformanceList");
        if (staffList == null || staffList.isEmpty()) {
    %>
        <div class="alert alert-info text-center">No staff performance data available.</div>
    <%
        } else {
    %>
        <div class="table-responsive">
            <table id="staffTable" class="table table-bordered table-striped table-hover">
                <thead class="table-dark text-center">
                    <tr>
                        <th>Staff ID</th>
                        <th>Name</th>
                        <th>Total Deliveries</th>
                        <th>Average Rating ⭐</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (StaffPerformanceBean staff : staffList) { %>
                        <tr class="text-center">
                            <td><%= staff.getStaffId() %></td>
                            <td><%= staff.getName() %></td>
                            <td><%= staff.getDeliveryCount() %></td>
                            <td><%= staff.getAvgRating() == 0.0 ? "No ratings yet" : String.format("%.2f", staff.getAvgRating()) %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    <% } %>

    <div class="text-center mt-4">
        <a href="adminDashBoard.jsp" class="btn btn-warning">← Back to Dashboard</a>
    </div>
</div>

<script>
    $(document).ready(function () {
        $('#staffTable').DataTable({
            pageLength: 10,
            order: [[2, 'desc']],
            language: {
                search: "_INPUT_",
                searchPlaceholder: "Search staff..."
            }
        });
    });
</script>

</body>
</html>
