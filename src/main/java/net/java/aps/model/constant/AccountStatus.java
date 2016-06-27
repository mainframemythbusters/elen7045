package net.java.aps.model.constant;

public enum AccountStatus {
	
	ACCOUNT_INVALID("Account number was not found!"),  
	ACCOUNT_ADDED("Account was successfully added to profile!");
	
	private String value;
	
	private AccountStatus(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}

}
