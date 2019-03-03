package edu.osu.cse5234.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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
public class OrderProcessingServiceBean {

	private static String shippingResourceURI = "http://localhost:9080/UPS/jaxrs";
    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
	
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
    	
		return orderNumber;
    	
    }
    
    public boolean validateItemAvailability (Order order) {
		
    	InventoryService is = (InventoryService) ServiceLocator.getInventoryService();
    	boolean allGood = is.validateQuantity(order.getItems());
    	
    	return allGood;
    }
}
