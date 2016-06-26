package net.java.aps.model.internal;

import javax.xml.bind.annotation.XmlRootElement;

import net.java.aps.model.StatementType;
import net.java.aps.model.constant.AccountCycle;
import net.java.aps.model.constant.AccountStatus;

@XmlRootElement
public class Account {
	
	private int accountNumber;
	private BillingCompany billingCompany;
	private AccountCredentials accountCredentials;
	private AccountStatus accountStatus;
	private AccountCycle accountCycle;
	private EdgarsStatementType statementType;
	
	
	public Account() {};
	
	/**
	 * 
	 * @param id
	 * @param accountName
	 * @param billingCompany
	 * @param accountCredentials
	 * @param accountStatus
	 * @param accountCycle
	 * @param statementType
	 */
	public Account(int accountNumber, BillingCompany billingCompany,
			AccountCredentials accountCredentials, AccountStatus accountStatus,
			AccountCycle accountCycle, EdgarsStatementType statementType) {
		super();
		this.accountNumber = accountNumber;
		this.billingCompany = billingCompany;
		this.accountCredentials = accountCredentials;
		this.accountStatus = accountStatus;
		this.accountCycle = accountCycle;
		this.statementType = statementType;
	}
	
	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the billingCompany
	 */
	public BillingCompany getBillingCompany() {
		return billingCompany;
	}
	/**
	 * @param billingCompany the billingCompany to set
	 */
	public void setBillingCompany(BillingCompany billingCompany) {
		this.billingCompany = billingCompany;
	}
	/**
	 * @return the accountCredentials
	 */
	public AccountCredentials getAccountCredentials() {
		return accountCredentials;
	}
	/**
	 * @param accountCredentials the accountCredentials to set
	 */
	public void setAccountCredentials(AccountCredentials accountCredentials) {
		this.accountCredentials = accountCredentials;
	}
	/**
	 * @return the accountStatus
	 */
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}
	/**
	 * @param accountStatus the accountStatus to set
	 */
	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}
	/**
	 * @return the accountCycle
	 */
	public AccountCycle getAccountCycle() {
		return accountCycle;
	}
	/**
	 * @param accountCycle the accountCycle to set
	 */
	public void setAccountCycle(AccountCycle accountCycle) {
		this.accountCycle = accountCycle;
	}
	/**
	 * @return the statementType
	 */
	public EdgarsStatementType getStatementType() {
		return statementType;
	}
	/**
	 * @param statementType the statementType to set
	 */
	public void setStatementType(EdgarsStatementType statementType) {
		this.statementType = statementType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		result = prime * result
				+ ((billingCompany == null) ? 0 : billingCompany.hashCode());
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
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (billingCompany == null) {
			if (other.billingCompany != null)
				return false;
		} else if (!billingCompany.equals(other.billingCompany))
			return false;
		return true;
	}

	
}
