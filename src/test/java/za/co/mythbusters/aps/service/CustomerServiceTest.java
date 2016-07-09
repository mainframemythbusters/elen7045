package za.co.mythbusters.aps.service;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import za.co.mythbusters.aps.model.constant.CustomerStatus;
import za.co.mythbusters.aps.model.internal.Customer;
import za.co.mythbusters.aps.model.internal.CustomerCredentials;
import za.co.mythbusters.aps.model.response.CustomerResponse;
import za.co.mythbusters.aps.repository.CustomerRepository;
import za.co.mythbusters.aps.service.CustomerService;
import junit.framework.TestCase;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


public class CustomerServiceTest extends TestCase {


	@InjectMocks
	CustomerService customerService;
	
	@Mock
	CustomerRepository customerRepository;
	
	protected void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testRegisterNewCustomer() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);
		
		//RegistrationResponse customerNotFoundResponse = new RegistrationResponse(false, RegistrationStatus.USER_REGISTERED);	
		//RegistrationResponse customerSavedResponse = new RegistrationResponse(true, RegistrationStatus.USER_REGISTERED);	
		
		when(customerRepository.findCustomer(mockedCustomer)).thenReturn(null);
		when(customerRepository.saveCustomer(mockedCustomer)).thenReturn(mockedCustomer);
		
		//When
		String result = customerService.registerCustomer(mockedCustomer).getResponseValue();
		
		//Then
		verify(customerRepository, times(1)).findCustomer(mockedCustomer);
		verify(customerRepository, times(1)).saveCustomer(mockedCustomer);
		assertEquals(result, CustomerStatus.USER_CREATED.getValue());
	}
	
	@Test
	public void testRegisterExistingCustomer() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);
		
		when(customerRepository.findCustomer(mockedCustomer)).thenReturn(mockedCustomer);
		when(customerRepository.saveCustomer(mockedCustomer)).thenReturn(mockedCustomer);
		
		//When
		String result = customerService.registerCustomer(mockedCustomer).getResponseValue();
		
		//Then
		verify(customerRepository, times(1)).findCustomer(mockedCustomer);
		verify(customerRepository, times(0)).saveCustomer(mockedCustomer);
		assertEquals(result, CustomerStatus.USER_EXIST.getValue());
	}
	
	
	@Test
	public void testLoginCustomer() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);
		
		when(customerRepository.findCustomer(mockedCustomer)).thenReturn(mockedCustomer);
		
		//When
		Customer result = customerService.loginCustomer(mockedCustomer);
		
		//Then
		verify(customerRepository, times(1)).findCustomer(mockedCustomer);
		assertEquals(result.getFirstName(), "sipho");
		assertEquals(result.getLastName(), "gumede");
	}
	
	@Test
	public void testInvalidLoginCustomer() throws Exception {
		
		//Given
		CustomerCredentials customerCredentials = new CustomerCredentials("custUserName", "custPassWord");		
		Customer mockedCustomer = new Customer("sipho", "gumede", customerCredentials, null);
		
		when(customerRepository.findCustomer(mockedCustomer)).thenReturn(null);
		
		//When
		Customer result = customerService.loginCustomer(mockedCustomer);
		
		//Then
		verify(customerRepository, times(1)).findCustomer(mockedCustomer);
		assertEquals(result, null);
	}

}
