package net.java.aps.model.constant;

public enum ProfileAccountStatus {
	
	ACCOUNT_ALREADY_EXIST("Account already exist!"),
	ACCOUNT_ADDED("Account added to profile!"), 
	ACCOUNT_PENDING("Account creation pending"),
	ACCOUNT_NOT_FOUND("Account not found!"),
	ACCOUNT_DELETED("Account deleted!"), 
	ACCOUNT_INVALID_CREDENTIALS("Account Credentials are invalid!"), 
	ACCOUNT_DOES_NOT_EXIST("Account does not exist");
	
	private String value;
	
	private ProfileAccountStatus(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}

}
