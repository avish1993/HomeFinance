package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utility.ConnectMySQL;
import business_logic.Customer;
import business_logic.Loan;

public class LoanDaoImpl implements LoanDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public void addCustomerLoanApplication(Customer customer, Loan loan)
			throws SQLException {

		Connection con = ConnectMySQL.getCon();
		ps = con.prepareStatement("insert into loan(customer_id, ref_no, loan_type, loan_amount, loan_code, property_address, down_payment, loan_period, emi, annual_income, other_income, open_date, interest_rate) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");

		// 1st the ref_no must be sent also loan code customer id,date

		ps.setString(1, customer.getId());
		ps.setString(2, loan.getRefNumber());
		ps.setString(3, loan.getAppliedFor());
		ps.setDouble(4, loan.getApprovedAmount());
		ps.setString(5, loan.getLoanProgramCode());
		ps.setString(6, loan.getAddressOfProperty());
		ps.setDouble(7, loan.getDownPayment());
		ps.setInt(8, loan.getLoanPeriod());
		ps.setDouble(9, loan.getEmiAmount());
		ps.setDouble(10, loan.getAnnualIncome());
		ps.setDouble(11, loan.getOtherIncome());
		ps.setDate(12, loan.getDateOfApplication());
		ps.setDouble(13, loan.getRateOfInterest());
		ps.executeUpdate();

	}

	@Override
	public void assignSalesRep(Loan loan, String salesRepId)
			throws SQLException {

		Connection con = ConnectMySQL.getCon();
		ps = con.prepareStatement("update loan set sales_rep_id=? where ref_no=?");

		ps.setString(1, salesRepId);
		ps.setString(2, loan.getRefNumber());

		ps.executeUpdate();

	}

	@Override
	public void editLoanApplication(Loan loan) throws SQLException {

		Connection con = ConnectMySQL.getCon();
		ps = con.prepareStatement("update loan set loan_amount=?, down_payment=?, loan_period=?, property_address=?, annual_income=? where ref_no = ?");

		ps.setDouble(1, loan.getApprovedAmount());
		ps.setDouble(2, loan.getDownPayment());
		ps.setInt(3, loan.getLoanPeriod());
		ps.setString(4, loan.getAddressOfProperty());
		ps.setDouble(5, loan.getAnnualIncome());
		ps.setString(6, loan.getRefNumber());
		ps.executeUpdate();
	}

	private void getLoan(Loan temp, ResultSet rs) throws SQLException {

		temp.setLoanProgramCode(rs.getString("loan_code"));
		temp.setRateOfInterest(rs.getDouble("interest_rate"));
		temp.setAddressOfProperty(rs.getString("property_address"));
		temp.setAppliedFor(rs.getString("loan_type"));
		temp.setApprovedAmount(rs.getDouble("loan_amount"));
		temp.setDownPayment(rs.getDouble("down_payment"));
		temp.setAnnualIncome(rs.getDouble("annual_income"));
		temp.setOtherIncome(rs.getDouble("other_income"));
		temp.setDateOfApplication(rs.getDate("open_date"));
		temp.setLoanPeriod(rs.getInt("loan_period"));
		temp.setEmiAmount(rs.getDouble("emi"));
		temp.setSalesRepID(rs.getString("sales_rep_id"));
		temp.setRefNumber(rs.getString("ref_no"));
	}

	@Override
	public ArrayList<Loan> getLoanListFromDB(String customerId)
			throws SQLException {

		Connection con = ConnectMySQL.getCon();
		ps = con.prepareStatement("select ref_no, loan_code, loan_type, open_date, property_address, annual_income, loan_amount, down_payment, loan_period, interest_rate, other_income, emi, sales_rep_id from loan where customer_id = ?");
		ps.setString(1, customerId);
		rs = ps.executeQuery();
		ArrayList<Loan> loanList = new ArrayList<Loan>();
		while (rs.next()) {
			Loan temp = new Loan();
			getLoan(temp, rs);
			loanList.add(temp);
		}
		return loanList;
	}

	@Override
	public ArrayList<Loan> getLoanListFromDB_srp(String salesRepId)
			throws SQLException {

		Connection con = ConnectMySQL.getCon();
		ps = con.prepareStatement("select ref_no, loan_code, loan_type, open_date, property_address, annual_income, loan_amount, down_payment, loan_period, interest_rate, other_income, emi, sales_rep_id from loan where sales_rep_id"
				+ (salesRepId == null ? " is null" : "=?"));
		if (salesRepId != null) {
			ps.setString(1, salesRepId);
		}
		rs = ps.executeQuery();
		ArrayList<Loan> loanList = new ArrayList<Loan>();
		while (rs.next()) {
			Loan temp = new Loan();
			getLoan(temp, rs);
			loanList.add(temp);
		}
		return loanList;
	}

}
