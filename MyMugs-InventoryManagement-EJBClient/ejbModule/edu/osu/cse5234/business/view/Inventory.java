package edu.osu.cse5234.business.view;

import java.util.List;

import edu.osu.cse5234.business.model.Item;

public class Inventory implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 10L;
	
	/** Properties **/
	 private List <Item> items;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List <Item> getItems() {
		return items;
	}

	public void setItems(List <Item> items) {
		this.items = items;
	}
    
}