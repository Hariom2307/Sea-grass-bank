<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <title>Fund Transfer</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }

        .container {
            margin-top: 50px;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #333;
        }

        .form-label {
            font-weight: bold;
        }

        .btn {
            margin: 5px 0;
        }

        .status-message {
            margin-top: 20px;
        }

        .back-link {
            margin-top: 20px;
            display: block;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Fund Transfer</h2>
        <form action="FundTransferController" method="POST" class="mt-4">
            <!-- Receiver's Account Number -->
            <div class="mb-3">
                <label for="receiverAccNo" class="form-label">Receiver's Account Number:</label>
                <input type="number" id="receiverAccNo" name="receiverAccNo" class="form-control" required>
            </div>

           

            <!-- Amount to Transfer -->
            <div class="mb-3">
                <label for="amount" class="form-label">Amount to Transfer:</label>
                <input type="number" id="amount" name="amount" class="form-control" required>
            </div>

            <!-- Password -->
            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>

            <!-- Options -->
            <h3 class="text-center">Choose an Option</h3>
            <div class="d-flex justify-content-center">
                <button type="submit" name="buttonValue" value="1" class="btn btn-primary">Debit</button>
            </div>
        </form>

        <!-- Fund Transfer Status -->
        <div class="status-message">
            <h4>Fund Transfer Status</h4>
            <%
                HttpSession session2 = request.getSession(false);
                if (session != null) {
                    String message = (String) session.getAttribute("message");
                    String historyMessage = (String) session.getAttribute("historyMessage");

                    if (message != null) {
                        out.println("<p class='text-success'>" + message + "</p>");
                        session.removeAttribute("message"); // Clear message after displaying
                    }

                    if (historyMessage != null) {
                        out.println("<p class='text-info'>" + historyMessage + "</p>");
                        session.removeAttribute("historyMessage"); // Clear historyMessage after displaying
                    }
                }
            %>
        </div>

        <!-- Back Link -->
       
