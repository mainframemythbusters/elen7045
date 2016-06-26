package net.java.aps.service;


import net.java.aps.model.constant.CustomerStatus;
import net.java.aps.model.internal.Customer;
import net.java.aps.model.response.CustomerResponse;
import net.java.aps.repository.CustomerRepository;
import net.java.aps.util.Utils;


public class CustomerService {


	CustomerRepository customerRepository;
	
	public CustomerResponse registerCustomer(Customer customer) {
			
		CustomerResponse response = new CustomerResponse(false, CustomerStatus.USER_PENDING);
		Customer responseCustomer = customerRepository.findCustomer(customer);		
		boolean isCustomerFound = isCustomerFound(responseCustomer);
		
		if(!isCustomerFound) {
			responseCustomer = customerRepository.saveCustomer(customer);
			response = new CustomerResponse(true, CustomerStatus.USER_CREATED);
		} else {
			response = new CustomerResponse(false, CustomerStatus.USER_EXIST);
		}
		
		return response;
	}

	private boolean isCustomerFound(Customer responseCustomer) {
		
		if(Utils.isEmpty(responseCustomer)) {
			return false;
		}		
		return true;
	}

	public Customer loginCustomer(Customer customer) {
		
		Customer responseCustomer = customerRepository.findCustomer(customer);
		boolean isCustomerFound = isCustomerFound(responseCustomer);
		
		if(!isCustomerFound) {
			return null;
		}
		
		return responseCustomer;
	}

}
