package com.caresoft.clinicapp.models;

public class User {
    protected Integer id;
    protected int pin;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
	

}
