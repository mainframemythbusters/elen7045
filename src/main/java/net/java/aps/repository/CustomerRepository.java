package net.java.aps.repository;

import net.java.aps.mocking.CustomerDataCollector;
import net.java.aps.model.internal.Customer;

public class CustomerRepository {

	public Customer saveCustomer(Customer customer) {
		
		Customer responseCustomer = CustomerDataCollector.saveCustomer(customer);		
		return responseCustomer;
	}

	public Customer findCustomer(Customer customer) {
		
		Customer responseCustomer = CustomerDataCollector.getCustomerFromXML(customer);
		
		if(!customer.equals(responseCustomer)) {
			responseCustomer = null;
		}
		
		return responseCustomer;
	}

}
