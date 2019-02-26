package edu.osu.cse5234.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENT_INFO")
public class PaymentInfo implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	
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

	/** Properties **/
	@Column(name="CARD_NUM")
    private String ccNumber;
	
	@Column(name="EXP_DATE")
    private String ccExpDate;
	
	@Column(name="CVV")
    private String ccCvvCode;
	
	@Column(name="HOLDER_NAME")
    private String ccHolderName;
    
    public String getCcNumber() {
		return ccNumber;
	}
	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	
	public String getCcExpDate() {
		return ccExpDate;
	}
	public void setCcExpDate(String ccExpDate) {
		this.ccExpDate = ccExpDate;
	}
	
	public String getCcCvvCode() {
		return ccCvvCode;
	}
	public void setCcCvvCode(String ccCvvCode) {
		this.ccCvvCode = ccCvvCode;
	}
	
	public String getCcHolderName() {
		return ccHolderName;
	}
	public void setCcHolderName(String ccHolderName) {
		this.ccHolderName = ccHolderName;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}