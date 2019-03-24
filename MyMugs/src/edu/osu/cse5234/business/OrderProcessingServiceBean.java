package edu.osu.cse5234.business;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

import com.ups.shipping.client.ShippingInitiationClient;
/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean

@Resource(name="jms/emailQCF", lookup="jms/emailQCF", type=ConnectionFactory.class)
public class OrderProcessingServiceBean {

	private static String shippingResourceURI = "http://localhost:9080/UPS/jaxrs";
    /**
     * Default constructor. 
     */
	
	@Inject
	@JMSConnectionFactory("jms/emailQCF")
	private JMSContext jmsContext;
	
	@Resource(lookup="jms/emailQ")
	private Queue queue;
	
	@PersistenceContext
	EntityManager entityManager;
	
	private void notifyUser(String customerEmail) {

		String message = customerEmail + ":" +
		       "Your order was successfully submitted. " + 
		     	"You will hear from us when items are shipped. " + 
		      	new Date();

		System.out.println("Sending message: " + message);
		jmsContext.createProducer().send(queue, message);
		System.out.println("Message Sent!");
	}
 
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }

    public String processOrder (Order order) {
		
    	InventoryService is = (InventoryService) ServiceLocator.getInventoryService();
    	boolean isOK = is.validateQuantity(order.getItems());
    	
    	if (isOK) {
    		
    		is.updateInventory(order.getItems());
    		entityManager.persist(order);
        	entityManager.flush();
    	}
    	
    	String orderNumber = String.valueOf(order.getId());
    	
    	JsonObject requestJson = Json.createObjectBuilder()
    			.add("Organization", "MyMugs Corp")
    			.add("OrderRefId", order.getId())
    			.add("Zip", order.getShipping().getZip())
    			.add("ItemsNumber", Integer.parseInt(order.getQuantityTotal()))
				.build();

    	
    	ShippingInitiationClient client = new ShippingInitiationClient(shippingResourceURI);
    	JsonObject responseJson = client.invokeInitiateShipping(requestJson);
    	System.out.println("UPS accepted request? " + responseJson.getBoolean("Accepted"));
    	System.out.println("Shipping Reference Number: " +  responseJson.getInt("ShippingReferenceNumber"));

    	if (responseJson.getBoolean("Accepted")) {
    		
    		String refNumber = String.valueOf(responseJson.getInt("ShippingReferenceNumber"));
    		order.getShipping().setShippingRefNumber(refNumber);
    		entityManager.persist(order);
        	entityManager.flush();
    	}
    	
    	notifyUser(order.getCustomerEmail());
    	
		return orderNumber;
    	
    }
    
    public boolean validateItemAvailability (Order order) {
		
    	InventoryService is = (InventoryService) ServiceLocator.getInventoryService();
    	boolean allGood = is.validateQuantity(order.getItems());
    	
    	return allGood;
    }
}
