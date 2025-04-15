package Controller;
import java.io.IOException;
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
 * Servlet implementation class Login
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long accountNumber = Long.parseLong(request.getParameter("acc"));
        String password = request.getParameter("password");
        Connection con = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstate = null;
        ResultSet rs = null;
        ResultSet rm = null;
        ResultSet ogname=null;
        String users = null;
        long phoneno=0;
        String email=null;
        String UserAddress=null;
        String originalName=null;
        String BranchCity=null;
        float currentBalance=0;
        
        UserService user = new UserService();

        try {
            // Establish Database Connection
            con = user.DBConnection(); // Assuming DBConnection is your utility class

            // SQL query to validate account number and password
            String query = "SELECT ACCNO, PASSWORD FROM registeruser WHERE ACCNO = ? AND PASSWORD = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setLong(1, accountNumber);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                // Fetch username if login is successful
                String usernameQuery = "SELECT * FROM registeruser WHERE ACCNO = ?";
                pstate = con.prepareStatement(usernameQuery);
                pstate.setLong(1, accountNumber);
                rm = pstate.executeQuery();
                if (rm.next()) {
                    users = rm.getString("USERNAME");
                    phoneno=rm.getLong("PHONENO");
                    email=rm.getString("EMAIL");
                    UserAddress=rm.getString("USER_ADDRESS");
                    BranchCity=rm.getString("BRANCHCITY");
                }
                String ogNameQuery="SELECT *FROM ACCOUNT  WHERE ACCNO = ?";
                pstmt=con.prepareStatement(ogNameQuery);
                pstmt.setLong(1, accountNumber);
                ogname=pstmt.executeQuery();
                if(ogname.next()) {
                	originalName=ogname.getString("ACCHOLDER_NAME");
                	currentBalance=ogname.getFloat("ACCBAL");
                	
                }
                
                
                
                // Set session attributes
                HttpSession session = request.getSession();
                session.setAttribute("Original Name", originalName);
                session.setAttribute("Username", users);
                session.setAttribute("accountNumber", accountNumber);
                session.setAttribute("CurrentBalance", currentBalance);
                session.setAttribute("Branchcity", BranchCity);
                session.setAttribute("PHONENO", phoneno);
                session.setAttribute("email", email);
                session.setAttribute("USER_ADDRESS", UserAddress);
                response.sendRedirect("Dashboard.jsp");
                
            } else {
                // If account or password is invalid
                response.sendRedirect("LoginView.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred while processing your request.");
        } finally {
            // Close resources
            try {
            	 if (ogname != null) ogname.close();
                if (rm != null) rm.close();
                if (rs != null) rs.close();
                if (pstate != null) pstate.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Error occurred during login validation. Please try again later.");
            }
        }
    }


}

