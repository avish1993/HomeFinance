package business_logic;

public class Manager {

	private String Name;
	private String Password;
	private BranchManager ownBranch;

	public String getName() {
		return Name;
	}

	public BranchManager getOwnBranch() {
		return ownBranch;
	}

	public String getPassword() {
		return Password;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setOwnBranch(BranchManager ownBranch) {
		this.ownBranch = ownBranch;
	}

	public void setPassword(String password) {
		Password = password;
	}
}
