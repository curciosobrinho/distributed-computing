package edu.osu.cse5234.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import edu.osu.cse5234.business.model.LineItem;

@Entity
@Table(name="CUSTOMER_ORDER")
public class Order implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2L;

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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public PaymentInfo getPayment() {
		return payment;
	}

	public void setPayment(PaymentInfo payment) {
		this.payment = payment;
	}

	public ShippingInfo getShipping() {
		return shipping;
	}

	public void setShipping(ShippingInfo shipping) {
		this.shipping = shipping;
	}

	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	@Column(name="CUSTOMER_EMAIL")
	private String customerEmail;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ORDER_ID_FK")
    private List <LineItem> items;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PAYMENT_INFO_ID_FK")
	private PaymentInfo payment;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="SHIPPING_INFO_ID_FK")
	private ShippingInfo shipping;

	
	@Transient
    private String orderTotal;
	@Transient
    private String quantityTotal;

	public List<LineItem> getItems() {
		return items;
	}

	public void setItems(List<LineItem> items) {
		this.items = items;
	}
    
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getOrderTotal() {
		
		float total = 0;
		
		
		for(LineItem item : this.items) {
			
			float qty = (float)item.getQuantity();
			
			total += (item.getPrice() * qty) ;
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
		
		for(LineItem item : this.items) {
			
			int qty = item.getQuantity();
			
			total += qty ;
		}
		
		quantityTotal = String.valueOf(total);
		
		return quantityTotal;
	}

	public void setQuantityTotal(String quantityTotal) {
		this.quantityTotal = quantityTotal;
	}
}
