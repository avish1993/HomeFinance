package business_logic;

public class SalesRepresentative {

	private String Name;
	private String salesRepID;
	private String Password;
	private boolean isAssigned;

	public String getName() {
		return Name;
	}

	public String getPassword() {
		return Password;
	}

	public String getSalesRepID() {
		return salesRepID;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public void setSalesRepID(String Id) {
		salesRepID = Id;
	}

}
