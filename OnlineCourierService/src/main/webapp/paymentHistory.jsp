<%@ page import="java.util.*, com.ashi.BeansandDAOs.PaymentBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Payment History</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/dataTables.bootstrap5.min.css">

    <style>
        body {
            background-color: #f9f9f9;
        }
        .table-container {
            margin-top: 60px;
            padding: 10px;
            background: #fff;
            border-radius: 15px;
            box-shadow: 0 0 12px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>

<%@ include file="navBarSuccess.jsp" %>

<div class="container-fluid mt-5 table-container mb-5 ">
    <h3 class="text-center mb-4 text-primary">Your Payment History</h3>

    <table id="paymentTable" class="table table-striped table-bordered table-hover border ">
        <thead class="table-dark">
            <tr>
                <th>Payment ID</th>
                <th>Order ID</th>
                <th>Amount (₹)</th>
                <th>Payment Date</th>
                <th>Method</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<PaymentBean> list = (List<PaymentBean>) request.getAttribute("paymentList");
            if (list != null && !list.isEmpty()) {
                for (PaymentBean p : list) {
        %>
            <tr>
                <td><%= p.getPaymentId() %></td>
                <td><%= p.getOrderId() %></td>
                <td><%= p.getAmount() %></td>
                <td><%= p.getPaymentDate() %></td>
                <td><%= p.getPaymentMethod() %></td>
                <td><%= p.getStatus() %></td>
            </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
   <div class="mt-2 text-center">
       <a href="customerDashboard.jsp" class="btn btn-warning mb-2">Back to DashBoard</a>
   </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<!-- jQuery (Required for DataTables) -->
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>

<!-- DataTables JS -->
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>

<script>
    $(document).ready(function() {
        $('#paymentTable').DataTable({
            "order": [[ 3, "desc" ]],  // Sort by payment date descending
            "pageLength": 10,
            "lengthMenu": [5, 10, 20, 50],
            "language": {
                "search": "Filter records:"
            }
        });
    });
</script>

</body>
</html>
