package za.co.mythbusters.aps.model.constant;

public enum AccountCycle {
	
	DAILY("daily"),
	WEEKLY("weekly"),
	MONTHLY("monthly");
	
	private String value;
	
	private AccountCycle(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}

}
