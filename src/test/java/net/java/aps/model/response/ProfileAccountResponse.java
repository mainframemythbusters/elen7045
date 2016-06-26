package net.java.aps.model.response;

import net.java.aps.model.constant.ProfileAccountStatus;
import net.java.aps.model.constant.ProfileStatus;

public class ProfileAccountResponse {
	
	private boolean isSuccess;
	private String responseValue;
		
	public ProfileAccountResponse(boolean isSuccess, ProfileAccountStatus profileAccountStatus) {
		this.isSuccess = isSuccess;
		this.responseValue = profileAccountStatus.getValue();
	}
	/**
	 * @return the isSuccess
	 */
	public boolean isSuccess() {
		return isSuccess;
	}
	/**
	 * @param isSuccess the isSuccess to set
	 */
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	/**
	 * @return the responseValue
	 */
	public String getResponseValue() {
		return responseValue;
	}
	/**
	 * @param responseValue the responseValue to set
	 */
	public void setResponseValue(String responseValue) {
		this.responseValue = responseValue;
	}
	
	

}
