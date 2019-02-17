package edu.osu.cse5234.model;

import java.math.BigDecimal;
import java.util.List;

import edu.osu.cse5234.business.model.Item;

public class Order implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	/** Properties **/
    private List <Item> items;
    private String orderTotal;
    private String quantityTotal;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
    
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getOrderTotal() {
		
		float total = 0;
		
		
		for(Item item : this.items) {
			
			float qty = Float.parseFloat(item.getQuantity());
			
			total += (Float.parseFloat(item.getPrice()) * qty) ;
		}
		
		orderTotal = String.valueOf(round(total,2));
		
		return orderTotal;
	}

	public void setOrderTotal(String orderTotal) {
		this.orderTotal = orderTotal;
	}
	
	public static float round(float d, int decimalPlace) {
	    BigDecimal bd = new BigDecimal(Float.toString(d));
	    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
	    return bd.floatValue();
	}

	public String getQuantityTotal() {
		
		int total = 0;
		
		for(Item item : this.items) {
			
			int qty = Integer.parseInt(item.getQuantity());
			
			total += qty ;
		}
		
		quantityTotal = String.valueOf(total);
		
		return quantityTotal;
	}

	public void setQuantityTotal(String quantityTotal) {
		this.quantityTotal = quantityTotal;
	}
}
