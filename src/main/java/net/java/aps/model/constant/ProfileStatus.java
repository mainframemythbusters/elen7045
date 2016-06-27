package net.java.aps.model.constant;

public enum ProfileStatus {
	
	PROFILE_ALREADY_EXIST("Profile already exist!"),
	PROFILE_CREATED("Profile created!"), 
	PROFILE_PENDING("Profile creation pending"),
	PROFILE_NOT_FOUND("Profile not found!"),
	PROFILE_DELETED("Profile deleted!");
	
	private String value;
	
	private ProfileStatus(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}

}
