package com.fan.abstractdemo.models;

import com.fan.abstractdemo.abstracts.Payment;

public class CreditCard extends Payment {
	
	private String cardNum, ownerName, expDate;
	
	public CreditCard(String cardNum,String ownerName,String expDate, double amount) {
		// TODO Auto-generated constructor stub
		super(amount);
		this.cardNum = cardNum;
		this.ownerName = ownerName;
		this.expDate = expDate;
		
	}
	
	@Override
	public void paymentDetails() {
		System.out.format("Card Number: %s \nCard OwnerName: %s \nCard Expire Date: %s \nPayment Amount:%.2f", this.cardNum, this.ownerName, this.expDate, this.getAmount());
		//alt+shift+y
	}

}
