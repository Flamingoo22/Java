package com.fan.fruityloop.models;

import java.util.ArrayList;

public class Store {
	private ArrayList<Fruit> items = new ArrayList<Fruit>();
	public Store() {
	}
	
	public Store( ArrayList<Fruit> items ) {
		this.items = items;
	}
	public ArrayList<Fruit> getItems() {
		return items;
	}
	public void setItems(ArrayList<Fruit> items) {
		this.items = items;
	}
	
}
