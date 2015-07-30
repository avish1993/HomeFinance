package dao;

import java.sql.SQLException;

import business_logic.Customer;

public interface CustomerDao {

	public boolean addCustomer(Customer cust) throws SQLException;

	public Customer getCustomer(String name, String password)
			throws SQLException;

	public boolean isExists(String name, String password) throws SQLException;

	public void updateAccount(Customer cust) throws SQLException;

}