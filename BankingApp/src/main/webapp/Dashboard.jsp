<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 100%;
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        .container h2 {
            text-align: center;
        }
        .menu {
            list-style-type: none;
            padding: 0;
        }
        .menu li {
            margin: 15px 0;
        }
        .menu li button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .menu li button:hover {
            background-color: #0056b3;
        }
    </style>
    <script>
        function redirectTo(page) {
            window.location.href = page;
        }
    </script>
</head>
<body>
    <div class="container">
        <h2>Dashboard</h2>
        <ul class="menu">
            <li><button onclick="redirectTo('FundTransfer.jsp')">Fund Transfer</button></li>
            <li><button onclick="redirectTo('Choices.jsp')">Bill Payments</button></li>
            <form action="AccountStatement" method="post"><li><button onclick="redirectTo('AccountStatement')">Account Statement</button></li></form>
            
            <li><button onclick="redirectTo('CheckBankBalance.jsp')">Check Account Balance</button></li>
        </ul>
    </div>
</body>
</html>
