
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Staff</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Optional: Custom CSS -->
    <style>
        .container {
            margin-top: 20px;
        }
        .table th, .table td {
            text-align: center;
        }
        .modal-header, .modal-footer {
            border: none;
        }
        .modal-body {
            padding: 20px;
        }
    </style>
</head>
<body>

<%@ include file="navbarAdmin.jsp" %>

<div class="container">
    <h2 class="text-center mb-4">Manage Delivery Agents</h2>
    
    <% if (request.getAttribute("deleteError") != null) { %>
    <div class="alert alert-info alert-dismissible fade show w-75  text-center" role="alert">
        <%= request.getAttribute("deleteError") %>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
<% } %>

<% if (request.getAttribute("deleteSuccess") != null) { %>
    <div class="alert alert-success alert-dismissible fade show w-75 text-center" role="alert">
        <%= request.getAttribute("deleteSuccess") %>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
<% } %>
    
    
    
    <div class="row mb-3">
     <div class="col">
         <a href="adminDashBoard.jsp" class="btn btn-warning">Goto DashBoard</a>
        </div>
        <div class="col text-end">
            <a href="addStaff.jsp" class="btn btn-primary">Add New Agent</a>
        </div>
       
    </div>
  
   <table class="table table-bordered table-striped table-hover shadow-lg">
    <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Phone</th>
            <th>UserID</th>
            <th>Password</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<DeliveryAgentBean> agents = (List<DeliveryAgentBean>) request.getAttribute("agents");
            if (agents != null) {
                for (DeliveryAgentBean agentBean : agents) {
        %>
            <tr>
                <td><%= agentBean.getStaffId() %></td>
                <td><%= agentBean.getName() %></td>
                <td><%= agentBean.getPhone() %></td>
                <td><%= agentBean.getUserId() %></td>
                <td><%= agentBean.getPassword() %></td>
                <td>
                    <div class="row">
                       <div class="col">
                          <a href="#" class="btn btn-warning btn-sm w-100 " data-bs-toggle="modal" data-bs-target="#editAgentModal"
                       data-agentid="<%= agentBean.getStaffId() %>" data-name="<%= agentBean.getName() %>"
                       data-phone="<%= agentBean.getPhone() %>" data-userid="<%= agentBean.getUserId() %>"
                       data-password="<%= agentBean.getPassword() %>">Edit</a>
                       </div>
                       
                       <div class="col">
                          <a href="#" class="btn btn-danger btn-sm w-100" data-bs-toggle="modal" data-bs-target="#deleteAgentModal"
                       data-agentid="<%= agentBean.getStaffId() %>" data-name="<%= agentBean.getName() %>">Delete</a>
                       </div>
                    </div>
                       
                    
                </td>
            </tr>
        <% 
                }
            }
        %>
    </tbody>
</table>
   
</div>

<!-- Edit Agent Modal -->
<!-- Edit Agent Modal -->
<div class="modal fade col-md-5" id="editAgentModal" tabindex="-1" aria-labelledby="editAgentModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editAgentModalLabel">Edit Delivery Agent</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="editAgent" method="POST" class="p-4">
                    <input type="hidden" id="editAgentId" name="agentId">
                    
                    <!-- Name Field -->
                    <div class="mb-3">
                        <label for="editAgentName" class="form-label">Name</label>
                        <input type="text" class="form-control" id="editAgentName" name="name" required>
                    </div>

                    <!-- Phone Field -->
                    <div class="mb-3">
                        <label for="editAgentPhone" class="form-label">Phone</label>
                        <input type="text" class="form-control" id="editAgentPhone" name="phone" required>
                    </div>

                    <!-- UserID Field -->
                    <div class="mb-3">
                        <label for="editAgentUserId" class="form-label">User ID</label>
                        <input type="text" class="form-control" id="editAgentUserId" name="userId" required>
                    </div>

                    <!-- Password Field -->
                    <div class="mb-3">
                        <label for="editAgentPassword" class="form-label">Password</label>
                        <input type="password" class="form-control" id="editAgentPassword" name="password">
                    </div>

                   

                    <!-- Action Buttons -->
                    <div class="text-center">
                        <button type="submit" class="btn btn-warning btn-lg">Update Agent</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<!-- Delete Agent Modal -->
<div class="modal fade" id="deleteAgentModal" tabindex="-1" aria-labelledby="deleteAgentModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteAgentModalLabel">Delete Agent</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>Are you sure you want to delete the agent <span id="deleteAgentName"></span>?</p>
            </div>
            <div class="modal-footer">
                <form action="deleteAgent" method="POST">
                    <input type="hidden" id="deleteAgentId" name="agentId">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

<!-- Optional: Custom JS -->
<script>
    // Edit Agent Modal - Pre-fill the form with agent data
    // Edit Agent Modal - Pre-fill the form with agent data
var editAgentModal = document.getElementById('editAgentModal');
editAgentModal.addEventListener('show.bs.modal', function (event) {
    var button = event.relatedTarget; // Button that triggered the modal
    var agentId = button.getAttribute('data-agentid');
    var name = button.getAttribute('data-name');
    var phone = button.getAttribute('data-phone');
    var userId = button.getAttribute('data-userid');
    var password = button.getAttribute('data-password');
    var deliveredDate = button.getAttribute('data-delivereddate'); // Optional: Date of delivery

    var modal = editAgentModal;
    modal.querySelector('#editAgentId').value = agentId;
    modal.querySelector('#editAgentName').value = name;
    modal.querySelector('#editAgentPhone').value = phone;
    modal.querySelector('#editAgentUserId').value = userId;
    modal.querySelector('#editAgentPassword').value = password;
    
});


    // Delete Agent Modal - Pre-fill the modal with agent data
    var deleteAgentModal = document.getElementById('deleteAgentModal');
    deleteAgentModal.addEventListener('show.bs.modal', function (event) {
        var button = event.relatedTarget; // Button that triggered the modal
        var agentId = button.getAttribute('data-agentid');
        var name = button.getAttribute('data-name');

        var modal = deleteAgentModal;
        modal.querySelector('#deleteAgentId').value = agentId;
        modal.querySelector('#deleteAgentName').textContent = name;
    });
</script>

</body>
</html>
