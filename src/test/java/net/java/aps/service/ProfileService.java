package net.java.aps.service;

import java.util.ArrayList;
import java.util.List;

import net.java.aps.model.constant.ProfileAccountStatus;
import net.java.aps.model.constant.ProfileStatus;
import net.java.aps.model.internal.Account;
import net.java.aps.model.internal.Profile;
import net.java.aps.model.response.CustomerResponse;
import net.java.aps.model.response.ProfileAccountResponse;
import net.java.aps.model.response.ProfileResponse;
import net.java.aps.repository.ProfileRepository;

public class ProfileService {

	ProfileRepository profileRepository;

	public ProfileResponse createProfile(Profile profile) {

		ProfileResponse response = new ProfileResponse(false,
				ProfileStatus.PROFILE_PENDING);
		Profile responseProfile = findProfile(profile);

		if (profile.equals(responseProfile)) {
			response = new ProfileResponse(false,
					ProfileStatus.PROFILE_ALREADY_EXIST);
		} else {
			profileRepository.saveProfile(profile);
			response = new ProfileResponse(true, ProfileStatus.PROFILE_CREATED);
		}

		return response;
	}

	public ProfileResponse deleteProfile(Profile profile) {

		ProfileResponse response = new ProfileResponse(false,
				ProfileStatus.PROFILE_PENDING);
		Profile responseProfile = findProfile(profile);

		if (profile.equals(responseProfile)) {
			response = new ProfileResponse(false, ProfileStatus.PROFILE_DELETED);
			profileRepository.deleteProfile(profile);
		} else {
			response = new ProfileResponse(true,
					ProfileStatus.PROFILE_NOT_FOUND);
		}

		return response;
	}

	private Profile findProfile(Profile profile) {

		Profile responseProfile = profileRepository.findProfile(profile);

		return responseProfile;
	}

	public ProfileAccountResponse addAccountToProfile(Profile profile,
			Account account) {

		ProfileAccountResponse response = new ProfileAccountResponse(false,
				ProfileAccountStatus.ACCOUNT_PENDING);

		boolean isAccountExistInProfile = isAccountExistInProfile(profile,
				account);
		boolean isAccountExistInRepository = isAccountExistInRepository(
				profile, account);

		/*
		 * if(!isValidAccountInformation(profile, account)) { return new
		 * ProfileAccountResponse(false,
		 * ProfileAccountStatus.ACCOUNT_INVALID_CREDENTIALS); }
		 */

		if (isAccountExistInProfile || isAccountExistInRepository) {
			response = new ProfileAccountResponse(false,
					ProfileAccountStatus.ACCOUNT_ALREADY_EXIST);

		} else {
			profileRepository.addAccountToProfile(profile, account);
			response = new ProfileAccountResponse(false,
					ProfileAccountStatus.ACCOUNT_ADDED);
		}

		return response;
	}

	private boolean isAccountExistInProfile(Profile profile, Account account) {

		boolean result = false;

		if (null != profile.getAccounts()) {
			for (Account accountFromProfile : profile.getAccounts()) {
				if (accountFromProfile.equals(account)) {
					result = true;
				}
			}
		}

		return result;
	}

	private boolean isAccountExistInRepository(Profile profile, Account account) {

		boolean result = false;

		Account repositoryAccount = profileRepository
				.findProfileAccount(account);

		if (null != repositoryAccount && repositoryAccount.equals(account)) {
			result = true;
		}

		return result;
	}
/*
	private boolean isValidAccountInformation(Profile profile, Account account) {

		boolean result = false;

		Account repositoryAccount = profileRepository
				.findProfileAccount(account);
		if (account.getAccountCredentials().equals(repositoryAccount)) {
			result = true;
		}
		return result;

	}*/

	public ProfileAccountResponse deleteAccountFromProfile(Profile profile,
			Account account) {
		
		ProfileAccountResponse response = null;
		List<Account> updatedAccountList = new ArrayList<Account>();
		
		if (null != profile.getAccounts()) {
			for (Account accountFromProfile : profile.getAccounts()) {
				if (!accountFromProfile.equals(account)) {
					updatedAccountList.add(accountFromProfile);
				} else {
					response = new ProfileAccountResponse(false,
							ProfileAccountStatus.ACCOUNT_DOES_NOT_EXIST);
				}
			}
		} else {
			return new ProfileAccountResponse(false,
					ProfileAccountStatus.ACCOUNT_DOES_NOT_EXIST);
		}
		profile.setAccounts(updatedAccountList);
		Profile deletedProfile = profileRepository.deleteProfile(profile);
		
		if(!profile.equals(deletedProfile)) {
			System.out.println("Account deleted");
			response = new ProfileAccountResponse(false,
				ProfileAccountStatus.ACCOUNT_DELETED);
		}
		
		return response;
	}
}
