package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FundImplement extends FundAbstract {
    UserService user = new UserService();
    Connection con = user.DBConnection();
    static float Amount = 0;

    @Override
    public int Debitamount(long accNo, float amount) {
        String query = "Select * from Account Where ACCNO=?";
        int i=0;
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setLong(1, accNo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                float retrievedAccBal = rs.getLong("ACCBAL");
                if (retrievedAccBal > 1000) {
                    if (retrievedAccBal - amount > 1000) {
                        retrievedAccBal = (long) (retrievedAccBal - amount);
                        PreparedStatement deductStmt = con.prepareStatement(
                            "UPDATE account SET ACCBAL =? WHERE ACCNO = ?");
                        deductStmt.setFloat(1, retrievedAccBal);
                        deductStmt.setLong(2, accNo);
                        
                         i=deductStmt.executeUpdate();
                    } else {
                        throw new InsufficientBalanceException();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return i;
    }

    @Override
    public int Creditamount(long accno, float amount) {
        String query = "Select * from Account Where ACCNO=?";
        int i=0;
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setLong(1, accno);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                long retrievedAccBal = rs.getLong("ACCBAL");
                retrievedAccBal = (long) (retrievedAccBal + amount);
                PreparedStatement deductStmt = con.prepareStatement(
                    "UPDATE account SET ACCBAL = retrievedAccBal WHERE ACCNO = ?");
                deductStmt.setLong(1, accno);
                i=deductStmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}

