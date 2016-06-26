package net.java.aps.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import net.java.aps.model.constant.AccountCycle;
import net.java.aps.model.constant.AccountStatus;
import net.java.aps.model.constant.CustomerStatus;
import net.java.aps.model.internal.Account;
import net.java.aps.model.internal.AccountCredentials;
import net.java.aps.model.internal.BillingCompany;
import net.java.aps.model.internal.Customer;
import net.java.aps.model.internal.CustomerCredentials;
import net.java.aps.model.internal.Profile;
import net.java.aps.model.response.CustomerResponse;
import net.java.aps.repository.CustomerRepository;
import junit.framework.TestCase;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


public class ProfileRepositoryTest extends TestCase {


	@InjectMocks
	ProfileRepository profileRepository;
	
	protected void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testFindProfileWhenProfileExist() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);
		Profile mockedProfile = new Profile("existingProfile", mockedCustomer, null);
		
		//When
		Profile result = profileRepository.findProfile(mockedProfile);
		
		//Then
		assertNotSame(result, mockedProfile);
	}
	
	@Test
	public void testFindProfileWhenProfileDoesNotExist() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);
		Profile mockedInvalidProfile = new Profile("invalidProfile", mockedCustomer, null);
		
		//When
		Profile result = profileRepository.findProfile(mockedInvalidProfile);
		
		//Then
		assertNotSame(result, mockedInvalidProfile);
	}
	
	@Test
	public void testSaveProfileWhenProfileDoesNotExist() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);
		Profile userProfile = new Profile("newProfile", mockedCustomer, null);
		
		//When
		Profile result = profileRepository.saveProfile(userProfile);
		
		//Then
		assertNotSame(result, userProfile);
	}
	
	@Test
	public void testSaveProfileWhenProfileExist() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);
		//Profile mockedInvalidProfile = new Profile("invalidProfile", mockedCustomer, null);
		Profile userProfile = new Profile("newProfile", mockedCustomer, null);
		
		//When
		Profile result = profileRepository.saveProfile(userProfile);
		
		//Then
		assertNotSame(result, userProfile);
	}
	
	@Test
	public void testAddToProfileWhenAccountDoesNotExist() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);		
				
		AccountCredentials mockedAccountCredentials = new AccountCredentials("custUserName", "custPassWord");
		BillingCompany mockedBillingCompany = new BillingCompany(1, "Edgars", "http://edgars.co.za/scrape"); 
		Account mockedAccount = new Account(12345, mockedBillingCompany, mockedAccountCredentials, AccountStatus.ACCOUNT_ADDED, AccountCycle.DAILY, null);
		
		List<Account> accountList = new ArrayList<Account>();
		accountList.add(mockedAccount);
		Profile mockedProfile = new Profile("existingProfile", mockedCustomer, accountList);
		
		//When
		Profile result = profileRepository.addAccountToProfile(mockedProfile, mockedAccount); 
		
		//Then
		assertNotSame(result.getAccounts().size(), mockedProfile.getAccounts().size());
	}
	
	@Test
	public void testDeleteAccountFromProfile() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);		
				
		AccountCredentials mockedAccountCredentials = new AccountCredentials("custUserName", "custPassWord");
		BillingCompany mockedBillingCompany1 = new BillingCompany(1, "Edgars", "http://edgars.co.za/scrape"); 
		BillingCompany mockedBillingCompany2 = new BillingCompany(2, "CreditCard", "http://creditcard.co.za/scrape"); 
		Account mockedAccount1 = new Account(12345, mockedBillingCompany1, mockedAccountCredentials, AccountStatus.ACCOUNT_ADDED, AccountCycle.DAILY, null);
		Account mockedAccount2 = new Account(67890, mockedBillingCompany2, mockedAccountCredentials, AccountStatus.ACCOUNT_ADDED, AccountCycle.DAILY, null);
		Account mockedAccountToDelete = new Account(67890, mockedBillingCompany2, mockedAccountCredentials, AccountStatus.ACCOUNT_ADDED, AccountCycle.DAILY, null);
		
		List<Account> accountList = new ArrayList<Account>();
		accountList.add(mockedAccount1);
		accountList.add(mockedAccount2);
		Profile mockedProfile = new Profile("existingProfile", mockedCustomer, accountList);
		
		//When
		Profile result = profileRepository.deleteProfile(mockedProfile, mockedAccountToDelete); 
		
		//Then
		assertNotSame(result.getAccounts().size(), mockedProfile.getAccounts().size());
	}
	
}
