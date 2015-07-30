package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import business_logic.BranchManager;

public interface BranchManagerDAO {

	void assignLoan(String srpId, String refNo) throws SQLException;

	// ArrayList<Loan> getUnassignedLoans() throws SQLException;

	ArrayList<String> getAllSrpId() throws SQLException;

	BranchManager getBManager(String name, String pass) throws SQLException;

	int getWorkLoad(String srpId) throws SQLException;

	boolean isExists(String name, String pass) throws SQLException;

	void updateDetails(BranchManager bMan) throws SQLException;
}
