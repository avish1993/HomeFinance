package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import business_logic.Loan;
import business_logic.SalesRepresentative;

public interface SalesRepresentativeDAO {

	public ArrayList<Loan> getLoanList(String srpId) throws SQLException;

	public boolean isExists(SalesRepresentative salesRP) throws SQLException;

	public void loanApprove(Loan loan) throws SQLException;

	public void loanReject(String refNo) throws SQLException;
}
