package com.chase.payment;

class CreditCardPayment implements java.io.Serializable {

  
	private static final long serialVersionUID = 12L;
	
	private int id;
	private String ccNumber;
    private String ccExpDate;
    private String ccCvvCode;
    private String ccHolderName;
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
