package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.ConnectMySQL;
import business_logic.Customer;
import business_logic.MD5Hash;

public class CustomerDaoImpl implements CustomerDao {

	private ResultSet rs;
	private PreparedStatement ps = null;

	@Override
	public boolean addCustomer(Customer customer) throws SQLException {

		Connection con = ConnectMySQL.getCon();

		ps = null;
		ps = con.prepareStatement("insert into customer (id, name, age, address, password, annual_income, phno) values (?,?,?,?,?,?,?)");

		ps.setString(1, customer.getId());
		ps.setString(2, customer.getName());
		ps.setInt(3, customer.getAge());
		ps.setString(4, customer.getAddress());
		ps.setString(5, customer.getPassword());
		ps.setDouble(6, customer.getAnnualIncome());
		ps.setString(7, customer.getPhoneNumber());

		if (ps.executeUpdate() > 0)
			return true;
		return false;

	}

	@Override
	public Customer getCustomer(String name, String password)
			throws SQLException {
		password = new MD5Hash(password).getHash();
		Connection con = ConnectMySQL.getCon();
		ps = con.prepareStatement("select id, annual_income, address, age, phno from customer where name=? and password=?");
		ps.setString(1, name);
		ps.setString(2, password);
		rs = ps.executeQuery();
		rs.next();
		Customer cust = new Customer();
		cust.setName(name);
		cust.setPassword(password);
		cust.setId(rs.getString("id"));
		cust.setAnnualIncome(rs.getDouble("annual_income"));
		cust.setAddress(rs.getString("address"));
		cust.setAge(rs.getInt("age"));
		cust.setPhoneNumber(rs.getString("phno"));
		LoanDao loanDB_handle = new LoanDaoImpl();
		cust.setLoanList(loanDB_handle.getLoanListFromDB(rs.getString("id")));
		return cust;
	}

	@Override
	public boolean isExists(String name, String pass) throws SQLException {

		Connection con = ConnectMySQL.getCon();
		pass = new MD5Hash(pass).getHash();
		ps = con.prepareStatement("select id from customer where name=? and password=?");
		ps.setString(1, name);
		ps.setString(2, pass);
		rs = ps.executeQuery();
		if (rs.next()) {
			return true;
		} else
			return false;
	}

	@Override
	public void updateAccount(Customer customer) throws SQLException {

		Connection con = ConnectMySQL.getCon();
		ps = con.prepareStatement("update customer set name=?, age=?, address=?, phno=?, annual_income=? where id=?");

		ps.setString(1, customer.getName());
		ps.setInt(2, customer.getAge());
		ps.setString(3, customer.getAddress());
		ps.setString(4, customer.getPhoneNumber());
		ps.setDouble(5, customer.getAnnualIncome());
		ps.setString(6, customer.getId());
		ps.executeUpdate();
	}

}
