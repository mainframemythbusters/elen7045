package net.java.aps.model.internal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

	private CustomerCredentials customerCredentials;
	private Profile customerProfile;
	private String firstName;
	private String lastName;
	
	public Customer() {}
	
	public Customer(String firstName,
					String lastName,
					CustomerCredentials customerCredentials,
					Profile customerProfile) {
		
		this.customerCredentials = customerCredentials;
		this.customerProfile = customerProfile;
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
	public CustomerCredentials getCredentials() {
		return customerCredentials;
	}

	/**
	 * @param credentials the credentials to set
	 */
	public void setCredentials(CustomerCredentials customerCredentials) {
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

	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return customerProfile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(Profile customerProfile) {
		this.customerProfile = customerProfile;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((customerCredentials == null) ? 0 : customerCredentials
						.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerCredentials == null) {
			if (other.customerCredentials != null)
				return false;
		} else if (!customerCredentials.equals(other.customerCredentials))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [customerCredentials=" + customerCredentials
				+ ", customerProfile=" + customerProfile + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}
	
	
}
