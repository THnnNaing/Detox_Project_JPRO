package Constructors;

public class Account {
	private int accountID; 
	private String username; 
	private String password; 
	private int staffID;
	
	public Account() {}
	
	public Account(int accountID, String username, String password, int staffID) {
		this.accountID = accountID;
		this.username = username;
		this.password = password;
		this.staffID = staffID;
	}

	public Account(String username, String password, int staffID) {
		
		this.username = username;
		this.password = password;
		this.staffID = staffID;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	
	
}
