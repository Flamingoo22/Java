package com.fan.abstractdemo;

import com.fan.abstractdemo.models.Cash;
import com.fan.abstractdemo.models.CreditCard;

public class AbstractDemoApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Payment pay = new Payment();
		Cash puppy = new Cash(699.9);
		
		System.out.println(puppy.getAmount());
		
		CreditCard laptop = new CreditCard( "5499 5244 4044 4444", "Bobby Brown","9/28", 2500.99);
		laptop.paymentDetails();
	}

}
