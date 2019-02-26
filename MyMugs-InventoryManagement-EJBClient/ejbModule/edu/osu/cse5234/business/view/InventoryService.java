package edu.osu.cse5234.business.view;

import java.util.List;

import edu.osu.cse5234.business.model.LineItem;

public interface InventoryService {

	public Inventory getAvailableInventory();
	
	public boolean validateQuantity(List<LineItem> list);
	
	public boolean updateInventory(List <LineItem> items);
}
