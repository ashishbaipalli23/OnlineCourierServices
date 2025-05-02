<%@page import="com.ashi.BeansandDAOs.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>

<!-- Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
  body {
    background: linear-gradient(to right, #f7f7f7, #e0e0e0);
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .logout-card {
    background-color: white;
    padding: 2rem 3rem;
    border-radius: 15px;
    box-shadow: 0px 5px 15px rgba(0,0,0,0.1);
    text-align: center;
    animation: fadeIn 1.2s ease-out;
  }

  .logout-card h2 {
    color: #dc3545;
  }

  .logout-card p {
    margin-bottom: 1.5rem;
    font-size: 1.1rem;
  }

  @keyframes fadeIn {
    0% {
      opacity: 0;
      transform: translateY(-20px);
    }
    100% {
      opacity: 1;
      transform: translateY(0);
    }
  }
</style>

<script>
  // Prevent going back to previous page
  history.pushState(null, null, location.href);
  window.onpopstate = function () {
      history.go(1);
  };
</script>

</head>
<body>

<%
   //remove attributes and invalidate session
   session.removeAttribute("customerBean");
   session.removeAttribute("courierBean");
   session.invalidate();
%>

<div class="logout-card">
  <h2>You have been logged out</h2>
  <p>Thank you for using our service!</p>
  <a href="login.jsp" class="btn btn-danger">Login Again</a>
</div>

</body>
</html>
