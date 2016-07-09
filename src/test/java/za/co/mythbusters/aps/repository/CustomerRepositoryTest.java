package za.co.mythbusters.aps.repository;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import za.co.mythbusters.aps.model.constant.CustomerStatus;
import za.co.mythbusters.aps.model.internal.Customer;
import za.co.mythbusters.aps.model.internal.CustomerCredentials;
import za.co.mythbusters.aps.model.response.CustomerResponse;
import za.co.mythbusters.aps.repository.CustomerRepository;
import junit.framework.TestCase;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


public class CustomerRepositoryTest extends TestCase {


	@InjectMocks
	CustomerRepository customerRepository;
	
	protected void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testFindCustomerWhenCustomerExist() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);
		
		//When
		Customer result = customerRepository.findCustomer(mockedCustomer);
		
		//Then
		assertEquals(result.getFirstName(), mockedCustomer.getFirstName());
		assertEquals(result.getLastName(), mockedCustomer.getLastName());
		assertEquals(result.getCredentials().getUsername(), mockedCustomer.getCredentials().getUsername());
	}
	
	@Test
	public void testFindCustomerWhenCustomerDoesNotExist() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sifiso", "gumede", customerCredentials, null);
		
		//When
		Customer result = customerRepository.findCustomer(mockedCustomer);
		
		//Then
		assertEquals(result, null);
	}
	
	@Test
	public void testSaveCustomerWhenCustomerDoesNotExist() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("john", "gumede", customerCredentials, null);
		
		//When
		Customer result = customerRepository.saveCustomer(mockedCustomer);
		
		//Then
		assertNotSame(result, mockedCustomer);
	}
	
	@Test
	public void testSaveCustomerWhenCustomerExist() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);
		
		//When
		Customer result = customerRepository.saveCustomer(mockedCustomer);
				
		//Then
		assertEquals(result, mockedCustomer);
	}

}
