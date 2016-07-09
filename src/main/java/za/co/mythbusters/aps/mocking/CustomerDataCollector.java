package za.co.mythbusters.aps.mocking;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import za.co.mythbusters.aps.model.constant.CustomerStatus;
import za.co.mythbusters.aps.model.internal.Customer;
import za.co.mythbusters.aps.model.internal.CustomerCredentials;

public class CustomerDataCollector {

	public static void main(String[] args) {

		//new CustomerDataCollector().createXMLFromObject();
		getCustomerFromXML(new CustomerDataCollector().getCustomer());

	}

	private Customer getCustomer() {
		
		CustomerCredentials customerCredentials = new CustomerCredentials(
				"custUserName", "custPassWord");
		Customer customer = new Customer("sipho", "gumede",
				customerCredentials, null);
		
		return customer;
	}
	
	public static Customer saveCustomer(Customer customer) {
		
		System.out.println("Customer saved to data storage...");
		return new CustomerDataCollector().getCustomer();
	}
	
	private static void createXMLFromObject(Customer customer) {

		/*CustomerCredentials customerCredentials = new CustomerCredentials(
				"custUserName", "custPassWord");
		Customer customer = new Customer("sipho", "gumede",
				customerCredentials, null);
*/
		try {
			File file = new File(System.getProperty("user.dir")
					+ "/mockdata/DataCustomer.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static Customer getCustomerFromXML(Customer customer) {

		//createXMLFromObject(customer);
		
		try {
			File file = new File(System.getProperty("user.dir")
					+ "/mockdata/DataCustomer.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			customer = (Customer) jaxbUnmarshaller.unmarshal(file);
			System.out.println(customer);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return customer;
	}

}
