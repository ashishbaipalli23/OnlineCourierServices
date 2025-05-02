<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Session Expired</title>

  <!-- Bootstrap CSS & Icons -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

  <style>
    body {
      background-color: #f8f9fa;
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
      margin: 0;
    }

    .message-box {
      background-color: #ffffff;
      padding: 40px 30px;
      border-radius: 20px;
      box-shadow: 0 4px 16px rgba(0, 0, 0, 0.1);
      text-align: center;
      max-width: 500px;
      width: 100%;
      animation: fadeIn 0.6s ease-in-out;
    }

    .message-box i.bi-exclamation-triangle-fill {
      font-size: 70px;
      color: #dc3545;
      animation: bounce 1.5s infinite;
    }

    .message-box h2 {
      margin-top: 20px;
      font-size: 1.3rem;
      color: #333;
    }

    .btn-login {
      margin-top: 30px;
    }

    @keyframes bounce {
      0%, 100% {
        transform: translateY(0);
      }
      50% {
        transform: translateY(-10px);
      }
    }

    @keyframes fadeIn {
      from {
        opacity: 0;
        transform: translateY(-20px);
      }
      to {
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

  <div class="message-box ">
    <i class="bi bi-exclamation-triangle-fill"></i>
    <h2 class="mt-3">
      <%= request.getAttribute("msg") != null 
            ? request.getAttribute("msg") 
            : "Your session has expired due to inactivity. Please log in again." %>
    </h2>
    <a href="deliveryAgentLogin.jsp" class="btn btn-info btn-lg btn-login text-light">
      <i class="bi bi-box-arrow-in-right me-1 "></i> Login Again
    </a>
  </div>

</body>
</html>
