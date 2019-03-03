package com.chase.payment;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class PaymentProcessor {


	public String ping() {
		return "All UP";
	}
	
	@WebMethod
	public String processPayment(CreditCardPayment creditCard) {
		return "01AOK";
	}
	
}
