package business_logic;

import java.util.ArrayList;

public class Customer {

	private String Name;
	private String Password;
	private String Address;
	private int Age;
	private double annualIncome;
	private String Id;

	private String branchCode;

	private String phoneNumber;
	private ArrayList<Loan> loanList = new ArrayList<Loan>();
	public void addLoan(Loan loan) {
		this.loanList.add(loan);
	}

	public String getAddress() {
		return Address;
	}

	public int getAge() {
		return Age;
	}

	public double getAnnualIncome() {
		return annualIncome;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public String getId() {
		return Id;
	}

	public ArrayList<Loan> getLoanList() {
		return loanList;
	}

	public String getName() {
		return Name;
	}

	public String getPassword() {
		return Password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public void setAge(int age) {
		Age = age;
	}

	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public void setId(String id) {
		Id = id;
	}

	public void setLoanList(ArrayList<Loan> loanList) {
		this.loanList = loanList;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setPassword(String password) {
		Password = new MD5Hash(password).getHash();
		if (Id == null) {
			Id = new MD5Hash(Password + Name).getHash().substring(0, 5);
		}
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
