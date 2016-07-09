package za.co.mythbusters.aps.model.response;

import za.co.mythbusters.aps.model.constant.ProfileStatus;

public class ProfileResponse {
	
	private boolean isSuccess;
	private String responseValue;
		
	public ProfileResponse(boolean isSuccess, ProfileStatus profileStatus) {
		this.isSuccess = isSuccess;
		this.responseValue = profileStatus.getValue();
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
