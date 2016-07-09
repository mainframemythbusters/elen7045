package za.co.mythbusters.aps.repository;

import za.co.mythbusters.aps.mocking.CustomerDataCollector;
import za.co.mythbusters.aps.model.internal.Customer;

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
