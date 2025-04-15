package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.UserAccount;

public class UserService {
	public Connection DBConnection(){
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","123456789");
			System.out.println("Connection to db");
			System.out.println("Connection is"+con);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public int saveUserToDatabase(UserAccount account) {
		int i=0;
		Connection con=DBConnection();
		try {
			PreparedStatement pst=con.prepareStatement("insert into registeruser values(?,?,?,?,?,?,?,?)");
			pst.setLong(1,account.getAccNo());
		    pst.setString(2,account.getBranchCity());
			pst.setString(3,account.getIFSCcode());
			pst.setString(4,account.getUser().getUsername());
			pst.setString(5,account.getUser().getPassword());
			pst.setString(6,account.getUser().getEmail());
			pst.setLong(7,account.getUser().getPhoneNo());
			pst.setString(8,account.getUser().getCity());
			i=pst.executeUpdate();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();

		}return i;


	}
	
	
	
	
//
//	public boolean validateAccountNumber(int senderAccNo,int receiverAccNo,float amount) throws SQLException {
//		// Database connection (using a try-with-resources for automatic closing)
//		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr1234")) {
//			System.out.println("Connection to db successful!");
//
//			// Prepared statement for query (prevents SQL injection)
//			String query="SELECT COUNT(*) FROM Account WHERE accNo = ? AND email = ? AND PhoneNo = ?";
//			try (PreparedStatement pstmt = con.prepareStatement(query)){
//				pstmt.setInt(1, senderAccNo);
//				pstmt.setInt(2, receiverAccNo);
//				pstmt.setFloat(3, amount);
//
//				ResultSet rs = pstmt.executeQuery();
//				if (rs.next() && rs.getInt(1) > 0) {
//					System.out.println("Validation Successful! Account exists in the database.");
//				} else {
//					System.out.println("Validation Failed! Account Number, Email, or Phone Number does not match.");
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("An error occurred during validation. Please check the database connection and credentials.");
//		}
//		return true;
//	}



}










