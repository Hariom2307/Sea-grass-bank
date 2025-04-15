<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Information</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        background-color: #f8f9fa;
        font-family: Arial, sans-serif;
        padding: 20px;
    }
    .container {
        max-width: 800px;
        margin: auto;
        background: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    h1 {
        font-size: 1.5rem;
        color: #343a40;
        margin-bottom: 15px;
    }
    .btn {
        display: inline-block;
        margin-top: 20px;
    }
</style>
</head>
<body>

<div class="container">
    <h2 class="text-center mb-4 text-primary">User Information</h2>

    <h1>Original Name: <span class="text-secondary"><%= session.getAttribute("Original Name") %></span></h1>
    <h1>Username: <span class="text-secondary"><%= session.getAttribute("Username") %></span></h1>
    <h1>Account Number: <span class="text-secondary"><%= session.getAttribute("accountNumber") %></span></h1>
    <h1>Branch City: <span class="text-secondary"><%= session.getAttribute("Branchcity") %></span></h1>
    <h1>Phone Number: <span class="text-secondary"><%= session.getAttribute("PHONENO") %></span></h1>
    <h1>Email Address: <span class="text-secondary"><%= session.getAttribute("email") %></span></h1>
    <h1>Current Balance: <span class="text-secondary"><%= session.getAttribute("CurrentBalance") %></span></h1>
    <h1>User Address: <span class="text-secondary"><%= session.getAttribute("USER_ADDRESS") %></span></h1>

    <a href="CheckBankBalance.jsp" class="btn btn-primary">Check Current Bank Balance</a>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
