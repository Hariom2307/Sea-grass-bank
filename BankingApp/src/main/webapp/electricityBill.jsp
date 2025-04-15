<!DOCTYPE html>
<html>
<head>
    <title>Electricity Bill Payment</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow border-0">
        <div class="card-body">
            <h1 class="text-center text-primary mb-4">Electricity Bill Payment</h1>

            <form action="ElectricityBillServlet" method="post">
                <div class="mb-3">
                    <label for="consumerNumber" class="form-label">Consumer Number:</label>
                    <input type="text" id="consumerNumber" name="consumerNumber" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="provider" class="form-label">Electricity Provider:</label>
                    <select id="provider" name="provider" class="form-select" required>
                        <option value="TNEB">TNEB</option>
                        <option value="MSEB">MSEB</option>
                        <option value="BESCOM">BESCOM</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="amount" class="form-label">Bill Amount:</label>
                    <input type="number" id="amount" name="amount" class="form-control" required>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-success btn-lg">Pay Bill</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>