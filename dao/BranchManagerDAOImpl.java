package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utility.ConnectMySQL;
import business_logic.BranchManager;
import business_logic.Loan;

public class BranchManagerDAOImpl implements BranchManagerDAO {

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public void assignLoan(String srpId, String refNo) throws SQLException {

		Connection con = ConnectMySQL.getCon();
		ps = con.prepareStatement("update loan set sales_rep_id=? where ref_no=?");
		ps.setString(1, srpId);
		ps.setString(2, refNo);
		ps.executeUpdate();
	}

	@Override
	public ArrayList<String> getAllSrpId() throws SQLException {
		Connection con = ConnectMySQL.getCon();
		ps = con.prepareStatement("select id from sales_rep");
		rs = ps.executeQuery();
		ArrayList<String> salesList = new ArrayList<String>();
		while (rs.next()) {
			salesList.add(rs.getString("id"));
		}
		return salesList;
	}

	@Override
	public BranchManager getBManager(String name, String pass)
			throws SQLException {
		Connection con = ConnectMySQL.getCon();
		ps = con.prepareStatement("select code, bname, city, state, zip, phno from branch where manager_name=? and password=?");
		ps.setString(1, name);
		ps.setString(2, pass);
		rs = ps.executeQuery();
		rs.next();
		BranchManager bman = new BranchManager();
		bman.setManagerName(name);
		bman.setManagerPass(pass);
		bman.setBranchCode(rs.getString("code"));
		bman.setBranchName(rs.getString("bname"));
		bman.setCity(rs.getString("city"));
		bman.setState(rs.getString("state"));
		bman.setZip(rs.getLong("zip"));
		bman.setPhone(rs.getString("phno"));
		bman.setUnassignedLoanList(getUnassignedLoans());
		return bman;
	}

	private ArrayList<Loan> getUnassignedLoans() throws SQLException {

		LoanDao loanDB_handle = new LoanDaoImpl();
		return loanDB_handle.getLoanListFromDB_srp(null);

	}

	@Override
	public int getWorkLoad(String srpId) throws SQLException {

		Connection con = ConnectMySQL.getCon();
		ps = con.prepareStatement("select count(ref_no) from loan where sales_rep_id=?");
		ps.setString(1, srpId);
		rs = ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	@Override
	public boolean isExists(String name, String pass) throws SQLException {
		Connection con = ConnectMySQL.getCon();
		ps = con.prepareStatement("select slno from branch where manager_name=? and password=?");
		ps.setString(1, name);
		ps.setString(2, pass);
		rs = ps.executeQuery();
		if (rs.next()) {
			return true;
		} else
			return false;
	}

	@Override
	public void updateDetails(BranchManager bMan) throws SQLException {
		Connection con = ConnectMySQL.getCon();
		ps = con.prepareStatement("update branch set bname=?, city=?, state=?, zip=?, phno=?, manager_name=? where code=?");
		ps.setString(1, bMan.getBranchName());
		ps.setString(2, bMan.getCity());
		ps.setString(3, bMan.getState());
		ps.setString(4, String.valueOf(bMan.getZip()));
		ps.setString(5, bMan.getPhone());
		ps.setString(6, bMan.getManagerName());
		ps.setString(7, bMan.getBranchCode());
		ps.executeUpdate();

	}
}
