<%@ page import="com.ashi.BeansandDAOs.CustomerBean" language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Navigation Bar</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
  <style>
    .navbar-brand {
      font-weight: bold;
      font-size: large;
    }
    body {
      background-color: #f2f2f2;
    }
  </style>
</head>
<body>
<%
  CustomerBean cb = (CustomerBean) session.getAttribute("customerBean");
  if (cb == null) {
    response.sendRedirect("login.jsp");
    return;
  }
%>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark py-3">
  <div class="container">
    <a class="navbar-brand fs-4" href="#">Online Courier Services</a>
    <div class="d-flex ms-auto align-items-center">
      <span class="text-light me-3 fs-5">
        <i class="bi bi-person-circle me-1"></i>Welcome, <%= cb.getName() %>!
      </span>
      <a href="logout.jsp" class="btn btn-outline-light btn-lg" onclick="return confirm('are you sure want to logout ?')">
        <i class="bi bi-box-arrow-right me-1"></i> Logout
      </a>
    </div>
  </div>
</nav>
</body>
</html>
