package Controller;
import java.sql.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.UserService;

/**
 * Servlet implementation class MobileRechargeServlet
 */
@WebServlet("/TVRechargeServlet")
public class TVReacharge extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */ 
	public TVReacharge() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		long accno = Long.parseLong(session.getAttribute("accountNumber").toString());
		
		if (accno == 0) {
			response.getWriter().println("Session expired. Please login again.");
			response.sendRedirect("LoginView.jsp");
			return;
		}

		long subscriberId = Long.parseLong(request.getParameter("consumerNumber"));
        String provider = request.getParameter("provider");
        float amount =Float.parseFloat( request.getParameter("amount"));

        if (subscriberId == 0 || provider == null || amount == 0) {
            response.getWriter().println("Invalid input. Please check your details.");
            return;
        }
		
		UserService userService = new UserService();
		
		Connection connection = userService.DBConnection();

		try {
			PreparedStatement fetchBalanceStmt = connection.prepareStatement("SELECT ACCBAL FROM account WHERE ACCNO = ?");
			fetchBalanceStmt.setLong(1, accno);
			ResultSet rs = fetchBalanceStmt.executeQuery();
			double currentBalance=0;

			if (rs.next()) {
				currentBalance = rs.getDouble("ACCBAL");
				
			}
			else {
				response.getWriter().println("<h2>Account not found.</h2>");
				return;
			}
			

			if (currentBalance >= amount && currentBalance - amount >= 1000) {
				double updatedBalance = currentBalance - amount;

				PreparedStatement updateBalanceStmt = connection.prepareStatement(
						"UPDATE account SET ACCBAL = ? WHERE ACCNO = ?");
				updateBalanceStmt.setDouble(1, updatedBalance);
				updateBalanceStmt.setLong(2, accno);
				Date currentDate = new Date(System.currentTimeMillis());
				int updateStatus = updateBalanceStmt.executeUpdate();

				if (updateStatus == 1) {

					PreparedStatement insertTransactionStmt = connection.prepareStatement(
							"INSERT INTO transactionhistory VALUES ( ?,?, ?, ?, ?)");

					insertTransactionStmt.setLong(1, subscriberId);
					insertTransactionStmt.setLong(2, accno);
					insertTransactionStmt.setDouble(3, amount);
					insertTransactionStmt.setDate(4,  currentDate);
					insertTransactionStmt.setDouble(5,  updatedBalance);
					
                    int transactionStatus = insertTransactionStmt.executeUpdate();

					if (transactionStatus == 1) {
						response.setContentType("text/html");
						PrintWriter out = response.getWriter();
						out.println("<h2>Electricity Bill Successful!</h2>");
						out.println("<p>Consumer No: " + subscriberId + "</p>");
						out.println("<p>Provider: " + provider + "</p>");
						out.println("<p>Amount: &#8377;" + amount + "</p>");
						out.println("<p>Your updated balance is &#8377;" + updatedBalance + "</p>");
						out.println("<a href='TVReachargesuccessfull.jsp'>Back to Dashboard</a>");
					} else {
						response.getWriter().println("<h2>Failed to record transaction. Please try again later.</h2>");
					}
				}else {
					response.getWriter().println("<h2>Recharge Failed. Please try again later.</h2>");
				}
			} else {
				response.getWriter().println("<h2>Insufficient Balance.</h2>");
				response.getWriter().println("<p>Your current balance is &#8377;" + currentBalance + "</p>");
				response.getWriter().println("<a href='TVReacharge.jsp'>Back</a>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().println("<h2>An error occurred while processing your request.</h2>");
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
