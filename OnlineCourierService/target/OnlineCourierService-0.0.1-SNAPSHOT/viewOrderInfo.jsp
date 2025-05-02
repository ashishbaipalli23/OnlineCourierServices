<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Info</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%@ include file="navbarAgent.jsp" %>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card shadow">
                <div class="card-header bg-primary text-white text-center">
                    <h5>🔍 Search Order by ID</h5>
                </div>

                <div class="card-body">
                    <form action="viewOrderInfo" method="get">
                        <div class="mb-3">
                            <label for="orderId" class="form-label">Enter Order ID</label>
                            <input type="number" class="form-control" name="orderId" id="orderId" placeholder="e.g. 1024" required>
                        </div>
                         <div class="row">
                            <div class="col">
                              <a href="agentDashBoard.jsp" class="btn btn-warning form-control">Back to dashBoard</a>
                            </div>
                            <div class="col">
                                 <button type="submit" class="btn btn-success w-100">View Order Info</button>
                            </div>
                         </div>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>
