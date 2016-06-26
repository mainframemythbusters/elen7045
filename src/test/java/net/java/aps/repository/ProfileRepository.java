package net.java.aps.repository;

import net.java.aps.mocking.ProfileDataCollector;
import net.java.aps.model.internal.Account;
import net.java.aps.model.internal.Customer;
import net.java.aps.model.internal.Profile;
import net.java.aps.model.response.ProfileResponse;

public class ProfileRepository {

	public Profile saveProfile(Profile profile) {
		
		Profile responseProfile = ProfileDataCollector.saveProfile(profile);
		return responseProfile;
	}

	public Profile findProfile(Profile profile) {
		
		Profile responseProfile = ProfileDataCollector.getProfileFromXML(profile);		
		return responseProfile;		
	}

	public Profile deleteProfile(Profile profile) {
		// TODO Auto-generated method stub
		return null;
	}

	public Profile addAccountToProfile(Profile profile, Account account) {
		
		Profile responseProfile = ProfileDataCollector.addAccountToProfile(profile, account);
		return responseProfile;
	}

	public Account findProfileAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Profile deleteAccountFromProfile(Profile profile, Account account) {
		
		return null;
	}

}
