package za.co.mythbusters.aps.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import za.co.mythbusters.aps.model.constant.AccountCycle;
import za.co.mythbusters.aps.model.constant.AccountStatus;
import za.co.mythbusters.aps.model.constant.CustomerStatus;
import za.co.mythbusters.aps.model.constant.ProfileAccountStatus;
import za.co.mythbusters.aps.model.constant.ProfileStatus;
import za.co.mythbusters.aps.model.internal.Account;
import za.co.mythbusters.aps.model.internal.AccountCredentials;
import za.co.mythbusters.aps.model.internal.BillingCompany;
import za.co.mythbusters.aps.model.internal.Customer;
import za.co.mythbusters.aps.model.internal.CustomerCredentials;
import za.co.mythbusters.aps.model.internal.Profile;
import za.co.mythbusters.aps.model.response.CustomerResponse;
import za.co.mythbusters.aps.repository.CustomerRepository;
import za.co.mythbusters.aps.repository.ProfileRepository;
import za.co.mythbusters.aps.service.ProfileService;
import junit.framework.TestCase;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


public class ProfileServiceTest extends TestCase {


	@InjectMocks
	ProfileService profileService;
	
	@Mock
	ProfileRepository profileRepository;
	
	protected void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testCreateNewProfile() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);
		Profile mockedProfile = new Profile("existingProfile", mockedCustomer, null);
		Profile userProfile = new Profile("newProfile", mockedCustomer, null);
		
		when(profileRepository.saveProfile(mockedProfile)).thenReturn(mockedProfile);
		when(profileRepository.findProfile(mockedProfile)).thenReturn(mockedProfile);
		
		//When
		String result = profileService.createProfile(userProfile).getResponseValue();
		
		//Then
		verify(profileRepository, times(1)).findProfile(userProfile);
		verify(profileRepository, times(1)).saveProfile(userProfile);
		assertEquals(result, ProfileStatus.PROFILE_CREATED.getValue());
	}
	
	@Test
	public void testCreateExistingProfile() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);
		Profile mockedProfile = new Profile("existingProfile", mockedCustomer, null);
		Profile userProfile = new Profile("existingProfile", mockedCustomer, null);
		
		when(profileRepository.saveProfile(mockedProfile)).thenReturn(mockedProfile);
		when(profileRepository.findProfile(mockedProfile)).thenReturn(mockedProfile);
		
		//When
		String result = profileService.createProfile(userProfile).getResponseValue();
		
		//Then
		verify(profileRepository, times(1)).findProfile(userProfile);
		assertEquals(result, ProfileStatus.PROFILE_ALREADY_EXIST.getValue());
	}
	
	@Test
	public void testDeleteExistingProfile() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);
		Profile mockedProfile = new Profile("existingProfile", mockedCustomer, null);
		Profile userProfile = new Profile("existingProfile", mockedCustomer, null);
		
		when(profileRepository.deleteProfile(mockedProfile)).thenReturn(mockedProfile);
		when(profileRepository.findProfile(mockedProfile)).thenReturn(mockedProfile);
		
		//When
		String result = profileService.deleteProfile(userProfile).getResponseValue();
		
		//Then
		verify(profileRepository, times(1)).findProfile(userProfile);
		verify(profileRepository, times(1)).deleteProfile(userProfile);
		assertEquals(result, ProfileStatus.PROFILE_DELETED.getValue());
	}
	
	@Test
	public void testDeleteNonExistingProfile() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);
		Profile mockedProfile = new Profile("existingProfile", mockedCustomer, null);
		Profile userProfile = new Profile("nonExistingProfile", mockedCustomer, null);
		
		when(profileRepository.deleteProfile(mockedProfile)).thenReturn(mockedProfile);
		when(profileRepository.findProfile(mockedProfile)).thenReturn(mockedProfile);
		
		//When
		String result = profileService.deleteProfile(userProfile).getResponseValue();
		
		//Then
		verify(profileRepository, times(1)).findProfile(userProfile);
		assertEquals(result, ProfileStatus.PROFILE_NOT_FOUND.getValue());
	}
	
	@Test
	public void testAddAccountWhereAccountDoesNotExistNewProfile() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);		
				
		AccountCredentials mockedAccountCredentials = new AccountCredentials("custUserName", "custPassWord");
		BillingCompany mockedBillingCompany = new BillingCompany(1, "Edgars", "http://edgars.co.za/scrape"); 
		Account mockedAccount = new Account(12345, mockedBillingCompany, mockedAccountCredentials, AccountStatus.ACCOUNT_ADDED, AccountCycle.DAILY, null);
		
		Profile mockedProfile = new Profile("existingProfile", mockedCustomer, null);
				
		when(profileRepository.addAccountToProfile(mockedProfile, mockedAccount)).thenReturn(mockedProfile);
		when(profileRepository.findProfileAccount(mockedAccount)).thenReturn(null);
		
		//When
		String result = profileService.addAccountToProfile(mockedProfile, mockedAccount).getResponseValue();
		
		//Then
		verify(profileRepository, times(1)).findProfileAccount(mockedAccount);
		verify(profileRepository, times(1)).addAccountToProfile(mockedProfile, mockedAccount);
		assertEquals(result, ProfileAccountStatus.ACCOUNT_ADDED.getValue());
	}
	
	@Test
	public void testAddAccountWhereAccountExistInProfile() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);		
		
		AccountCredentials mockedAccountCredentials = new AccountCredentials("custUserName", "custPassWord");
		BillingCompany mockedBillingCompany = new BillingCompany(1, "Edgars", "http://edgars.co.za/scrape"); 
		Account mockedAccount = new Account(12345, mockedBillingCompany, mockedAccountCredentials, AccountStatus.ACCOUNT_ADDED, AccountCycle.DAILY, null);
		
		List<Account> accountList = new ArrayList<Account>();
		accountList.add(mockedAccount);
		Profile mockedProfile = new Profile("existingProfile", mockedCustomer, accountList);
		
		when(profileRepository.addAccountToProfile(mockedProfile, mockedAccount)).thenReturn(mockedProfile);
		when(profileRepository.findProfileAccount(mockedAccount)).thenReturn(mockedAccount);
		
		//When
		String result = profileService.addAccountToProfile(mockedProfile, mockedAccount).getResponseValue();
		
		//Then
		verify(profileRepository, times(1)).findProfileAccount(mockedAccount);
		assertEquals(result, ProfileAccountStatus.ACCOUNT_ALREADY_EXIST.getValue());
	}
	
	@Test
	public void testAddAccountWhereAccountExistInRepository() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);		
		
		AccountCredentials mockedAccountCredentials = new AccountCredentials("custUserName", "custPassWord");
		BillingCompany mockedBillingCompany = new BillingCompany(1, "Edgars", "http://edgars.co.za/scrape"); 
		Account mockedAccount = new Account(12345, mockedBillingCompany, mockedAccountCredentials, AccountStatus.ACCOUNT_ADDED, AccountCycle.DAILY, null);
		
		Profile mockedProfile = new Profile("existingProfile", mockedCustomer, null);
		
		when(profileRepository.addAccountToProfile(mockedProfile, mockedAccount)).thenReturn(mockedProfile);
		when(profileRepository.findProfileAccount(mockedAccount)).thenReturn(mockedAccount);
		
		//When
		String result = profileService.addAccountToProfile(mockedProfile, mockedAccount).getResponseValue();
		
		//Then
		verify(profileRepository, times(1)).findProfileAccount(mockedAccount);
		assertEquals(result, ProfileAccountStatus.ACCOUNT_ALREADY_EXIST.getValue());
	}
	
	@Test
	public void testDeleteAccountFromProfileWhereAccountExist() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);			
		
		AccountCredentials mockedAccountCredentials = new AccountCredentials("custUserName", "custPassWord");
		//AccountCredentials mockedInvalidAccountCredentials = new AccountCredentials("invalidcustUserName", "custPassWord");
		
		BillingCompany mockedBillingCompany = new BillingCompany(1, "Edgars", "http://edgars.co.za/scrape"); 
		Account mockedAccount = new Account(12345, mockedBillingCompany, mockedAccountCredentials, AccountStatus.ACCOUNT_ADDED, AccountCycle.DAILY, null);
		//Account mockedInvalidAccount = new Account(12345, mockedBillingCompany, mockedInvalidAccountCredentials, AccountStatus.ACCOUNT_ADDED, AccountCycle.DAILY, null);
		
		List<Account> accountList = new ArrayList<Account>();
		accountList.add(mockedAccount);
		Profile mockedProfile = new Profile("existingProfile", mockedCustomer, accountList);
		Profile mockedDeletedProfile = new Profile("existingProfile", mockedCustomer, null);
		
		when(profileRepository.deleteProfile(mockedProfile)).thenReturn(mockedDeletedProfile);
		
		//When
		String result = profileService.deleteAccountFromProfile(mockedProfile, mockedAccount).getResponseValue();
		
		//Then
		verify(profileRepository, times(1)).deleteProfile(mockedProfile);
		assertEquals(result, ProfileAccountStatus.ACCOUNT_DELETED.getValue());
	}
	
	@Test
	public void testDeleteAccountFromProfileWhereAccountDoesNoExist() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);			
		
		AccountCredentials mockedAccountCredentials = new AccountCredentials("custUserName", "custPassWord");
		//AccountCredentials mockedInvalidAccountCredentials = new AccountCredentials("invalidcustUserName", "custPassWord");
		
		BillingCompany mockedBillingCompany = new BillingCompany(1, "Edgars", "http://edgars.co.za/scrape"); 
		Account mockedAccount = new Account(12345, mockedBillingCompany, mockedAccountCredentials, AccountStatus.ACCOUNT_ADDED, AccountCycle.DAILY, null);
		//Account mockedInvalidAccount = new Account(12345, mockedBillingCompany, mockedInvalidAccountCredentials, AccountStatus.ACCOUNT_ADDED, AccountCycle.DAILY, null);
		
		List<Account> accountList = new ArrayList<Account>();
		accountList.add(mockedAccount);
		Profile mockedProfile = new Profile("existingProfile", mockedCustomer, null);
		
		when(profileRepository.deleteProfile(mockedProfile)).thenReturn(mockedProfile);
		
		//When
		String result = profileService.deleteAccountFromProfile(mockedProfile, mockedAccount).getResponseValue();
		
		//Then
		//verify(profileRepository, times(1)).deleteProfile(mockedProfile);
		assertEquals(result, ProfileAccountStatus.ACCOUNT_DOES_NOT_EXIST.getValue());
	}

}
