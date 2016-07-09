package za.co.mythbusters.aps.mocking;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DataCustomer {

	private DataCustomerCredentials customerCredentials;
	private String firstName;
	private String lastName;
	
	public DataCustomer() {}
	
	public DataCustomer(String firstName,
					String lastName,
					DataCustomerCredentials customerCredentials) {
		
		this.customerCredentials = customerCredentials;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the credentials
	 */
	public DataCustomerCredentials getCredentials() {
		return customerCredentials;
	}

	/**
	 * @param credentials the credentials to set
	 */
	public void setCredentials(DataCustomerCredentials customerCredentials) {
		this.customerCredentials = customerCredentials;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
}
