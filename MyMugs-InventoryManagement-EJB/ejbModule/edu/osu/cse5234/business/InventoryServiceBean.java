package edu.osu.cse5234.business;

import edu.osu.cse5234.business.model.Item;
import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
	
	final String MY_QUERY = "select i from Item i";
	
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

    public Inventory getAvailableInventory() {

		Inventory inventory = new Inventory();
		List <Item> orderList = entityManager.createQuery(MY_QUERY, Item.class).getResultList();
		inventory.setItems(orderList);
		return inventory;
		
	}
	
	public boolean validateQuantity(List <Item> items) {
		
		List <Item> dbItems = entityManager.createQuery(MY_QUERY, Item.class).getResultList();
		
		for (Item item : items) {
			
			for (Item dbItem : dbItems) {
				
				if (dbItem.getId() == item.getId()) {
					
					if(item.getAvailableQuantity() > dbItem.getAvailableQuantity() ) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public boolean updateInventory(List <Item> items) {
		return true;
	}
}
