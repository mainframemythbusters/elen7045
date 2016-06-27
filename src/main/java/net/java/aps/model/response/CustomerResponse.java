package net.java.aps.model.response;

import net.java.aps.model.constant.CustomerStatus;

public class CustomerResponse {
	
	private boolean isSuccess;
	private String responseValue;
		
	public CustomerResponse(boolean isSuccess, CustomerStatus customerStatus) {
		this.isSuccess = isSuccess;
		this.responseValue = customerStatus.getValue();
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
