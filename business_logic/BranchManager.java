package business_logic;

import java.util.ArrayList;

public class BranchManager {

	private String branchCode;
	private String branchName;
	private String City;
	private String State;
	private long Zip;
	private String phoneNumber;
	private String managerName;
	private String managerPass;
	private ArrayList<Loan> unassignedLoanList;

	public String getBranchCode() {
		return branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public String getCity() {
		return City;
	}

	public String getManagerName() {
		return managerName;
	}

	public String getManagerPass() {
		return managerPass;
	}

	public String getPhone() {
		return phoneNumber;
	}

	public String getState() {
		return State;
	}

	public ArrayList<Loan> getUnassignedLoanList() {
		return unassignedLoanList;
	}

	public long getZip() {
		return Zip;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public void setCity(String city) {
		City = city;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public void setManagerPass(String managerPass) {
		this.managerPass = managerPass;
	}

	public void setPhone(String phone) {
		this.phoneNumber = phone;
	}

	public void setState(String state) {
		State = state;
	}

	public void setUnassignedLoanList(ArrayList<Loan> unassignedLoanList) {
		this.unassignedLoanList = unassignedLoanList;
	}

	public void setZip(long zip) {
		Zip = zip;
	}

}
