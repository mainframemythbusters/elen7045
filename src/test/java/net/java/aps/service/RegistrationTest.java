package net.java.aps.service;

import org.junit.Test;

import net.java.aps.model.internal.Customer;
import net.java.aps.repository.RegistrationRepository;
import net.java.aps.service.RegistrationService;
import junit.framework.TestCase;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class RegistrationTest extends TestCase {


	/*RegistrationService registrationService;
	RegistrationRepository registrationRepository;
	Customer customer;
	
	protected void setUp() throws Exception {
		//super.setUp();
		registrationService = mock(RegistrationService.class);
		
		customer = new Customer(8866758,"myUser", "myPass", "user@aps.com", "Mandla", "Khosa");
		
		when(registrationService.registerCustomer(customer)).thenReturn(customer.getCustomerNumber());
		
		
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testRegisterCustomer() throws Exception {
		
		int customerNumber = registrationService.registerCustomer(customer);
	    assertNotNull(customerNumber);
	    assertEquals(customer.getCustomerNumber(), customerNumber);
	}
*/
}
