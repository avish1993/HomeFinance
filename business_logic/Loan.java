package business_logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Loan {

	private String salesRepID;
	public String refNumber;
	private double approvedAmount;
	private double downPayment;
	private double emiAmount;
	private double rateOfInterest;
	private int loanPeriod;
	public String loanProgramCode;
	private java.sql.Date dateOfApplication;

	private String addressOfProperty;

	private double annualIncome;

	private double otherIncome;

	private String appliedFor;
	private boolean Loan_status = false;
	public Loan() {

	}
	public Loan(String loanProgramCode) {

		this.loanProgramCode = loanProgramCode;

		switch (this.loanProgramCode) {
		case "Lp01":
			this.setAppliedFor("Purchase of property");
			this.rateOfInterest = 5.75;
			break;
		case "Lp02":
			this.setAppliedFor("Construction of property on preowned land");
			this.rateOfInterest = 6.25;
			break;
		case "Lp03":
			this.setAppliedFor("Renovation of preowned property");
			this.rateOfInterest = 7;
			break;
		case "Lp04":
			this.setAppliedFor("Extension of preowned property");
			this.rateOfInterest = 4.23;
			break;
		}
	}
	public String getAddressOfProperty() {
		return addressOfProperty;
	}

	public double getAnnualIncome() {
		return annualIncome;
	}

	public String getAppliedFor() {
		return appliedFor;
	}

	public double getApprovedAmount() {
		return approvedAmount;
	}

	public java.sql.Date getDateOfApplication() {
		return dateOfApplication;
	}

	public double getDownPayment() {
		return downPayment;
	}

	public double getEmiAmount() {

		int N = loanPeriod * 12;
		emiAmount = approvedAmount * (rateOfInterest / 1200)
				* Math.pow((1 + rateOfInterest / 1200), N - 1)
				/ (Math.pow((rateOfInterest / 1200) + 1, N) - 1);
		return emiAmount;
	}

	public boolean getLoan_status() {
		return Loan_status;
	}

	public int getLoanPeriod() {
		return loanPeriod;
	}

	public String getLoanProgramCode() {
		return loanProgramCode;
	}

	public double getOtherIncome() {
		return otherIncome;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public String getRefNumber() {
		return refNumber;
	}

	public String getSalesRepID() {
		return salesRepID;
	}

	public void setAddressOfProperty(String addressOfProperty) {
		this.addressOfProperty = addressOfProperty;
	}

	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public void setAppliedFor(String appliedFor) {
		this.appliedFor = appliedFor;
	}

	public void setApprovedAmount(double approvedAmount) {
		this.approvedAmount = approvedAmount;
	}

	public void setDateOfApplication(java.sql.Date dateOfApplication) {
		this.dateOfApplication = dateOfApplication;
	}

	public void setDateOfApplication(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date parsed = null;
		try {
			parsed = format.parse(date);
		} catch (ParseException e) {
		}
		this.dateOfApplication = new java.sql.Date(parsed.getTime());
	}

	public void setDownPayment(double downPayment) {
		this.downPayment = downPayment;
	}

	public void setEmiAmount(double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public void setLoan_status(boolean loan_status) {
		Loan_status = loan_status;
	}

	public void setLoanPeriod(int loanPeriod) {
		this.loanPeriod = loanPeriod;
	}

	public void setLoanProgramCode(String loanProgramCode) {
		this.loanProgramCode = loanProgramCode;
	}

	public void setOtherIncome(double otherIncome) {
		this.otherIncome = otherIncome;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}

	public void setSalesRepID(String salesRepID) {
		this.salesRepID = salesRepID;
	}
}
