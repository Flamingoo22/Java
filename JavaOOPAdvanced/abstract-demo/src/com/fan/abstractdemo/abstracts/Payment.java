package com.fan.abstractdemo.abstracts;

public abstract class Payment {
	
	private double amount;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}
	
	public Payment(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void paymentDetails() {
		System.out.println("Payment amount: "+ this.amount);
	}
}
