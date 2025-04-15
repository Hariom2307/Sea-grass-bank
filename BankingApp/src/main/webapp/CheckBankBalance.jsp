<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Account Details</title>
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
        max-width: 800px;
        margin: 30px auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }

    h1 {
        color: #007bff;
        font-size: 24px;
        margin-bottom: 20px;
        text-align: center;
        font-weight: normal;
    }

    .section {
        background-color: #f9f9f9;
        margin-bottom: 20px;
        padding: 15px;
        border-radius: 8px;
        box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    }

    .section h1 {
        font-size: 20px;
        color: #2c3e50;
    }

    .section p {
        font-size: 18px;
        color: #7f8c8d;
        margin-top: 10px;
    }

    footer {
        text-align: center;
        font-size: 14px;
        margin-top: 30px;
        color: #7f8c8d;
    }
</style>
</head>
<body>

<div class="container">
    <h1 class="text-primary">User Account Details</h1>
    <div class="section border p-3 mb-3 rounded shadow-sm">
        <h1 class="h5">User Name:</h1>
        <p class="text-secondary"><%= session.getAttribute("Username") %></p>
    </div>

    <div class="section border p-3 mb-3 rounded shadow-sm">
        <h1 class="h5">Account Number:</h1>
        <p class="text-secondary"><%= session.getAttribute("accountNumber") %></p>
    </div>

    <div class="section border p-3 mb-3 rounded shadow-sm">
        <h1 class="h5">Current Balance:</h1>
        <p class="text-secondary"><%= session.getAttribute("CurrentBalance") %></p>
    </div>
</div>
<div></div>
<footer>
    <p>&copy; 2024 Your Company Name. All rights reserved.</p>
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>