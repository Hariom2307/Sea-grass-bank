<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>User Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: rgba(255, 255, 255, 0.8);
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h2 {
            text-align: center;
            color: #007bff;
            margin-bottom: 20px;
            font-size: 24px;
            font-weight: bold;
        }

        form {
            background-color: rgba(255, 255, 255, 0.9);
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 15px;
            max-width: 600px;
            box-sizing: border-box;
        }

        label {
            grid-column: span 1;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"],
        input[type="number"],
        input[type="submit"] {
            grid-column: span 1;
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
            outline: none;
            box-sizing: border-box;
        }

        input[type="text"]:focus,
        input[type="password"]:focus,
        input[type="email"]:focus,
        input[type="number"]:focus {
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        }

        input[type="submit"] {
            grid-column: span 2;
            padding: 12px;
            background-color: #007bff;
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0062cc;
        }
    </style>
</head>
<body>

    <h2>User Registration Form</h2>

    <form action="RegisterController" method="post">
        <label for="accNo">Account Number:</label>
        <input type="number" id="accNo" name="accNo" aria-label="Account Number" required />

        <label for="branchCity">Branch City:</label>
        <input type="text" id="branchCity" name="branchCity" aria-label="Branch City" required />

        <label for="IFSCcode">IFSC Code:</label>
        <input type="text" id="IFSCcode" name="IFSCcode" aria-label="IFSC Code" required />

        <label for="username">Username:</label>
        <input type="text" id="username" name="username" aria-label="Username" required />

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" aria-label="Password" required />

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" aria-label="Email" required />

        <label for="PhoneNo">Phone Number:</label>
        <input type="text" id="PhoneNo" name="PhoneNo" aria-label="Phone Number" pattern="[0-9]{10}" title="Enter a valid 10-digit phone number" required />

        <label for="city">City:</label>
        <input type="text" id="city" name="city" aria-label="City" required />

        <input type="submit" value="Register" />
    </form>
</body>
</html>
