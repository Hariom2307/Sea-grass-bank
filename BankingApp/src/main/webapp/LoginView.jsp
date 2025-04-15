<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .login-container {
        background-color: #fff;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        text-align: center;
        width: 300px;
    }
    h1 {
        color: #333;
    }
    label {
        display: block;
        margin: 10px 0 5px;
        text-align: left;
    }
    input[type="number"],
    input[type="password"] {
        width: calc(100% - 22px);
        padding: 5px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    .button-container {
        display: flex;
        justify-content: space-between;
    }
    button[type="submit"] {
        width: 48%;
        padding: 10px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s;
        margin-bottom: 10px;
    }
    button[type="submit"]:hover {
        background-color: #0056b3;
    }
    .table-container {
        text-align: center;
        margin-top: 20px;
    }
    a {
        color: #007bff;
        text-decoration: none;
        display: block;
        margin-top: 10px;
    }
    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
<div class="login-container">
    <h1>Login</h1>
    <form action="LoginController" method="post">
        <label for="acc">Enter your Account Number:</label>
        <input type="number" id="acc" name="acc" required>

        <label for="password">Enter password:</label>
        <input type="password" id="password" name="password" required>

        <div class="button-container">
            <button type="submit" name="action" value="signin">Sign In</button>
            <button type="submit" name="action" value="cancel">Cancel</button>
        </div>
        <a href="RegisterView.jsp">New user? Register here</a>
    </form>
</div>
</body>
</html>