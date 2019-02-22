package edu.osu.cse5234.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {

    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }

    public String processOrder (Order order) {
		
    	InventoryService is = (InventoryService) ServiceLocator.getInventoryService();
    	boolean isOK = is.validateQuantity(order.getItems());
    	
    	if (isOK) {
    		
    		is.updateInventory(order.getItems());
    	}
    	
    	int randomNum = ThreadLocalRandom.current().nextInt(0, 100000 + 1);
    	
    	String orderNumber = String.valueOf(randomNum);
		
		return orderNumber;
    	
    }
    
    public boolean validateItemAvailability (Order order) {
		
    	InventoryService is = (InventoryService) ServiceLocator.getInventoryService();
    	return is.validateQuantity(order.getItems());
    	
    }
}
