package edu.osu.cse5234.model;

public class PaymentInfo implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	
	/** Properties **/
    private String ccNumber;
    private String ccExpDate;
    private String ccCvvCode;
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