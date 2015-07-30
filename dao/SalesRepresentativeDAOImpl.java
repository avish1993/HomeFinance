package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import utility.ConnectMySQL;
import business_logic.Loan;
import business_logic.SalesRepresentative;

public class SalesRepresentativeDAOImpl implements SalesRepresentativeDAO {

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public ArrayList<Loan> getLoanList(String srpId) throws SQLException {

		LoanDao loanDB_handle = new LoanDaoImpl();
		ArrayList<Loan> loanList = loanDB_handle.getLoanListFromDB_srp(srpId);

		return loanList;

	}

	@Override
	public boolean isExists(SalesRepresentative salesRP) throws SQLException {

		Connection con = ConnectMySQL.getCon();
		ps = con.prepareStatement("select id from sales_rep where name=? and password=?");
		ps.setString(1, salesRP.getName());
		ps.setString(2, salesRP.getPassword());
		rs = ps.executeQuery();
		if (rs.next()) {
			salesRP.setSalesRepID(rs.getString("id"));
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void loanApprove(Loan loan) throws SQLException {

		Connection con = ConnectMySQL.getCon();

		ps = con.prepareStatement("update loan set loan_status=?, close_date=?, down_payment=?, annual_income=?, property_address=?, loan_period=?, loan_amount=? where ref_no=?");
		ps.setBoolean(1, loan.getLoan_status());
		java.util.Date utilDate = new Date();
		java.sql.Date date = new java.sql.Date(utilDate.getTime());
		ps.setDate(2, date);
		ps.setDouble(3, loan.getDownPayment());
		ps.setDouble(4, loan.getAnnualIncome());
		ps.setString(5, loan.getAddressOfProperty());
		ps.setInt(6, loan.getLoanPeriod());
		ps.setDouble(7, loan.getApprovedAmount());
		ps.setString(8, loan.getRefNumber());
		ps.executeUpdate();
		JOptionPane.showMessageDialog(null, "Loan Approved!");

	}

	@Override
	public void loanReject(String refNo) throws SQLException {
		Connection con = ConnectMySQL.getCon();
		ps = con.prepareStatement("delete from loan where ref_no=?");
		ps.setString(1, refNo);
		ps.executeUpdate();
	}
}
