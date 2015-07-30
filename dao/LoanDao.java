package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import business_logic.Customer;
import business_logic.Loan;

public interface LoanDao {

	public void addCustomerLoanApplication(Customer customer, Loan loan)
			throws SQLException;

	public void assignSalesRep(Loan loan, String salesRepId)
			throws SQLException;

	public void editLoanApplication(Loan loan) throws SQLException;

	public ArrayList<Loan> getLoanListFromDB(String customerId)
			throws SQLException;

	public ArrayList<Loan> getLoanListFromDB_srp(String salesRepId)
			throws SQLException;

	// public void SalesRepRejectLoan() throws SQLException;

	/* public void FindUnassignedLoan() throws SQLException; */

}