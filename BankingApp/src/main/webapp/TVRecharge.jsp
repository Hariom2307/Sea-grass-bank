<!DOCTYPE html>
<html>
<head>
    <title>TV Recharge</title>
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
            max-width: 600px;
            margin: 30px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        h1 {
            color: #007bff;
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
            margin-top: 10px;
        }

        .btn {
            width: 100%;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>TV Recharge</h1>
    <form action="TVRechargeServlet" method="post">
        <div class="mb-3">
            <label for="subscriberId" class="form-label">Subscriber ID:</label>
            <input type="text" class="form-control" id="subscriberId" name="subscriberId" required>
        </div>

        <div class="mb-3">
            <label for="provider" class="form-label">TV Provider:</label>
            <select class="form-select" id="provider" name="provider" required>
                <option value="DishTV">DishTV</option>
                <option value="TataSky">TataSky</option>
                <option value="AirtelDigital">Airtel Digital TV</option>
            </select>
        </div>

        <div class="mb-3">
            <label for="amount" class="form-label">Recharge Amount:</label>
            <input type="number" class="form-control" id="amount" name="amount" required>
        </div>

        <button type="submit" class="btn btn-primary">Recharge</button>
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>