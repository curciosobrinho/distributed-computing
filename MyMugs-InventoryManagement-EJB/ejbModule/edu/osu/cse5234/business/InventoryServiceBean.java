package edu.osu.cse5234.business;

import edu.osu.cse5234.business.model.Item;
import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {

    /**
     * Default constructor. 
     */
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

    public Inventory getAvailableInventory() {
    	Item item1 = new Item();
		item1.setName("Cup Wonder");
		item1.setPrice("5.90");

		Item item2 = new Item();
		item2.setName("Cup Magic");
		item2.setPrice("4.90");

		Item item3 = new Item();
		item3.setName("Cup Dad Rocks");
		item3.setPrice("6.10");

		Item item4 = new Item();
		item4.setName("Cup Follow Steps");
		item4.setPrice("5.80");

		Inventory inventory = new Inventory();
		List<Item> orderList = new ArrayList<Item>();
		orderList.add(item1);
		orderList.add(item2);
		orderList.add(item3);
		orderList.add(item4);

		inventory.setItems(orderList);
		
		return inventory;
		
	}
	
	public boolean validateQuantity(List <Item> items) {
		return true;
	}
	
	public boolean updateInventory(List <Item> items) {
		return true;
	}
}
