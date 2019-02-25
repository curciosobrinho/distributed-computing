package edu.osu.cse5234.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ITEM")
public class Item implements java.io.Serializable {

    /**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	
	/** Properties **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	@Column(name="ITEM_NUMBER")
	private int itemNumber;
	
	@Column(name="NAME")
    private String name;
	
	@Column(name="DESCRIPTION")
    private String description;
	
	@Column(name="AVAILABLE_QUANTITY")
    private int availableQuantity;
	
	@Column(name="UNIT_PRICE")
    private double unitPrice;
    
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}