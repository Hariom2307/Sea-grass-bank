<%@page import="Model.TransactionHistory"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Transaction" %>

<!DOCTYPE html>
<html>
<head>
    <title>Display List</title>
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
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Item List</h2>
        <%
            ArrayList<TransactionHistory> list = (ArrayList<TransactionHistory>) session.getAttribute("list");
            
        %>
        <table>
            <thead>
                <tr>
                    <th>Account Number</th>
                    <th>Sender Number</th>
                    <th>Fund</th>
                    <th>Date</th>
                    <th>Current Balance</th>
                </tr>
            </thead>
            <tbody>
                <% for(TransactionHistory trans: list) { %>
                <tr>
                    <td><%= trans.getReceiverAccNo()%></td>
                    <td><%= trans.getSenderAccNo() %></td>
                    <td><%= trans.getAmount() %></td>
                    <td><%= trans.getTransactionDate() %></td>
                    <td><%= trans.getCURRBAL() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>

