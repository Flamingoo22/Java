package com.fan.abstractArt.models;

import com.fan.abstractArt.abstracts.Art;

public class Sculpture extends Art {
	
	private String material;
	
	public Sculpture(String title, String author, String description, String material) {
	super(title, author, description);
	this.material = material;
	// TODO Auto-generated constructor stub
	}

	@Override
	public void viewArt() {
		// TODO Auto-generated method stub
		System.out.format(" Title: %s \n Author: %s \n Description: %s \n Material: %s \n\n", this.getTitle(), this.getAuthor(), this.getDescription(), this.material);
	}

}
