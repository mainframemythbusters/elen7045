package net.java.aps.mocking;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import net.java.aps.model.constant.AccountCycle;
import net.java.aps.model.constant.AccountStatus;
import net.java.aps.model.constant.CustomerStatus;
import net.java.aps.model.internal.Account;
import net.java.aps.model.internal.AccountCredentials;
import net.java.aps.model.internal.BillingCompany;
import net.java.aps.model.internal.Customer;
import net.java.aps.model.internal.CustomerCredentials;
import net.java.aps.model.internal.Profile;

public class ProfileDataCollector {

	public static void main(String[] args) {

		//new ProfileDataCollector().createXMLFromObject(new ProfileDataCollector().getProfile());
		getProfileFromXML(new ProfileDataCollector().getProfile());

	}

	private Profile getProfile() {
		
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);		
				
		AccountCredentials mockedAccountCredentials = new AccountCredentials("custUserName", "custPassWord");
		BillingCompany mockedBillingCompany = new BillingCompany(1, "Edgars", "http://edgars.co.za/scrape"); 
		Account mockedAccount = new Account(12345, mockedBillingCompany, mockedAccountCredentials, AccountStatus.ACCOUNT_ADDED, AccountCycle.DAILY, null);
		
		List<Account> accountList = new ArrayList<Account>();
		accountList.add(mockedAccount);
		Profile mockedProfile = new Profile("existingProfile", mockedCustomer, accountList);
		
		return mockedProfile;
	}
	
	public static Profile addAccountToProfile(Profile profile, Account account) {
		
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);		
				
		AccountCredentials mockedAccountCredentials = new AccountCredentials("custUserName", "custPassWord");
		BillingCompany mockedBillingCompany1 = new BillingCompany(1, "Edgars", "http://edgars.co.za/scrape"); 
		BillingCompany mockedBillingCompany2 = new BillingCompany(2, "CreditCard", "http://creditcard.co.za/scrape"); 
		Account mockedAccount1 = new Account(12345, mockedBillingCompany1, mockedAccountCredentials, AccountStatus.ACCOUNT_ADDED, AccountCycle.DAILY, null);
		Account mockedAccount2 = new Account(67890, mockedBillingCompany2, mockedAccountCredentials, AccountStatus.ACCOUNT_ADDED, AccountCycle.DAILY, null);
		
		List<Account> accountList = new ArrayList<Account>();
		accountList.add(mockedAccount1);
		accountList.add(mockedAccount2);
		Profile mockedProfile = new Profile("existingProfile", mockedCustomer, accountList);
		
		return mockedProfile;
	}
	
	public static Profile saveProfile(Profile profile) {
		
		System.out.println("Customer saved to data storage...");
		return new ProfileDataCollector().getProfile();
	}
	
	private static void createXMLFromObject(Profile profile) {

		/*CustomerCredentials customerCredentials = new CustomerCredentials(
				"custUserName", "custPassWord");
		Customer customer = new Customer("sipho", "gumede",
				customerCredentials, null);
*/
		try {
			File file = new File(System.getProperty("user.dir")
					+ "/mockdata/DataProfileList.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Profile.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(profile, file);
			jaxbMarshaller.marshal(profile, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static Profile getProfileFromXML(Profile profile) {

		//createXMLFromObject(customer);
		
		try {
			File file = new File(System.getProperty("user.dir")
					+ "/mockdata/DataProfile.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Profile.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			profile = (Profile) jaxbUnmarshaller.unmarshal(file);
			System.out.println(profile);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return profile;
	}

}
