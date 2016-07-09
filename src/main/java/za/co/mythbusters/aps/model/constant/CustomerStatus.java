package za.co.mythbusters.aps.model.constant;

public enum CustomerStatus {
	
	USER_CREATED("User was successfully registered!"), 
	USER_PENDING("User busy with registration!"), 
	USER_EXIST("User already exist!");
	
	private String value;
	
	private CustomerStatus(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}

}
