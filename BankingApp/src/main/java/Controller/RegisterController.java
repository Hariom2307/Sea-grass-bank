package Controller;

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

import Model.UserAccount;
import Model.UserRegister;
import Service.UserService;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		long accNo = Long.parseLong(request.getParameter("accNo"));
		
		String branchCity = request.getParameter("branchCity");
		String IFSCcode = (request.getParameter("IFSCcode"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		long phoneNo = Long.parseLong(request.getParameter("PhoneNo"));
		String city = request.getParameter("city");

		UserRegister user=new UserRegister(username, password, email, phoneNo, city);
		UserAccount account=new UserAccount(accNo, branchCity,IFSCcode ,user);
		UserService userservice=new UserService();


		ResultSet rs;
		try {
			Connection con=userservice.DBConnection();
			String query="Select * from account Where ACCNO=?";
			PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setLong(1, accNo);
				rs = pstmt.executeQuery();
				 if (rs.next()) {
				        long retrievedAccNo = rs.getLong("ACCNo");
				        System.out.println("Validation Successful! Account exists in the database: " + retrievedAccNo);
	                    int isUserSaved=userservice.saveUserToDatabase(account);
						pw.print("2");
						if (isUserSaved>0) {
							response.sendRedirect("LoginView.jsp");
							pw.print("3");
						}
						else {
							System.out.println("Error: Failed to save user to the database.");
							pw.print("Failed to save user.");
							request.getRequestDispatcher("RegisterView.jsp").forward(request, response);
						} 
					}else {
						// Handle account validation failure
						System.out.println("Validation Failed! Account information does not match.");
						pw.print("Validation failed. Account information does not match");
					}
				

			
			pw.print("4");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}
}


