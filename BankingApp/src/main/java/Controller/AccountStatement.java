package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Transaction;
import Model.TransactionHistory;
import Service.UserService;

/**
 * Servlet implementation class AccountStatement
 */
@WebServlet("/AccountStatement")
public class AccountStatement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountStatement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserService uservice=new UserService();
		Connection con=uservice.DBConnection();
		HttpSession session = request.getSession();
        TransactionHistory trans=new TransactionHistory();
        long accountNo = Long.parseLong(session.getAttribute("accountNumber").toString()); 
		try {
			PreparedStatement pstate=con.prepareStatement("select * from transactionhistory where ACCNO=?");
			pstate.setLong(1,accountNo);
			List<TransactionHistory>tr=new ArrayList<TransactionHistory>();
			ResultSet rs=pstate.executeQuery();
			
			if(rs.next()) {
				 TransactionHistory trans1=new TransactionHistory();
				long acc1=(rs.getLong(1));
				long acc2=(rs.getLong(2));
				float amount=(rs.getFloat(3));
				Date date=(rs.getDate(4));
				float curr=(rs.getFloat(5));
				tr.add(new TransactionHistory(acc1,acc2, amount, date, curr));
				
			}
			
			session.setAttribute("list", tr);
			request.getRequestDispatcher("AccountStatement.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
