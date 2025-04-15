<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Service Choices</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
        margin: 0;
        padding: 0;
    }

    .container {
        margin-top: 50px;
        max-width: 600px;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        margin: 10px 0;
    }

    a {
        text-decoration: none;
        color: #007bff;
        font-weight: bold;
    }

    a:hover {
        color: #0056b3;
        text-decoration: underline;
    }
</style>
</head>
<body>
<div class="container">
    <h2 class="text-center text-primary mb-4">Select a Service</h2>
    <form action="ChoiceServlet" method="post">
        <ul class="list-group">
            <li class="list-group-item">
                <a href="MobileReacharge.jsp" class="btn btn-link">Mobile Recharge</a>
            </li>
            <li class="list-group-item">
                <a href="TVRecharge.jsp" class="btn btn-link">TV Recharge</a>
            </li>
            <li class="list-group-item">
                <a href="electricityBill.jsp" class="btn btn-link">Electricity Bill</a>
            </li>
        </ul>
    </form>
</div>
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
