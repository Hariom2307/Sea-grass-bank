package Controller;
import java.sql.Date;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.TransactionHistory;
import Service.FundImplement;
import Service.UserService;

/**
 * Servlet implementation class FundTransferController
 */
@WebServlet("/FundTransferController")
public class FundTransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FundTransferController() {
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
		long recieverno=Long.parseLong(request.getParameter("receiverAccNo"));
		HttpSession session = request.getSession();
		long senderno = Long.parseLong(session.getAttribute("accountNumber").toString()); 
		float amount=Float.parseFloat(request.getParameter("amount"));
		String password=request.getParameter("password");
		long Currentbalance=0;
		int row=0;
		FundImplement fund=new FundImplement();
		UserService uservice=new UserService();
		
		
		Connection con=uservice.DBConnection();
		 
		
		int choice=Integer.parseInt(request.getParameter("buttonValue"));

		switch(choice) {
		case 1:
			int i=fund.Debitamount(senderno, amount);
			if(i>0) {
				System.out.println("successfull!!!");
//				response.getWriter().println("Transaction Successful! Amount deducted.");
				 session.setAttribute("message", "Transaction Successful! Amount deducted.");
//				response.sendRedirect("FundTransfer.jsp");
			}else {
				System.out.println("Transaction Failed! Please check account details or balance.");
//	            response.getWriter().println("Transaction Failed! Please check account details or balance.");
	            session.setAttribute("message", "Transaction Failed! Please check account details or balance.");
			}
			break;
		case 2:
			int i1=fund.Creditamount(senderno, amount);
			if(i1>0) {
				System.out.println("successfull!!!");
				 session.setAttribute("message", "Transaction Successful! Amount credited.");
//				response.getWriter().println("Transaction Successful! Amount deducted.");
//				response.sendRedirect("FundTransfer.jsp");
			}else {
				System.out.println("Transaction Failed! Please check account details or balance.");
				session.setAttribute("message", "Transaction Failed! Please check account details or balance.");
//	            response.getWriter().println("Transaction Failed! Please check account details or balance.");
			}
			break;
		
		}
		
		
		try {
			PreparedStatement pupdate=con.prepareStatement("select * from account where ACCNO=?");
			pupdate.setLong(1,senderno);
			ResultSet rs=pupdate.executeQuery();
			if(rs.next()) {
				Currentbalance=rs.getLong("ACCBAL");
			}
			Date currentDate = new Date(System.currentTimeMillis());
			PreparedStatement pstate=con.prepareStatement("Insert into TRANSACTIONHISTORY values(?,?,?,?,?)");
			pstate.setLong(1,recieverno);
			pstate.setLong(2,senderno);
			pstate.setFloat(3,amount);
			pstate.setDate(4, currentDate);
			pstate.setLong(5,Currentbalance);
			row=pstate.executeUpdate();
			if(row>0) {
//				response.getWriter().println("Successful");
				session.setAttribute("historyMessage", "Transaction history updated successfully.");
            } else {
                session.setAttribute("historyMessage", "Failed to update transaction history.");
            }
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  response.sendRedirect("FundTransfer.jsp");
}
}
