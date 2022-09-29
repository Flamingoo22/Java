package com.fan.abstractArt.models;

import com.fan.abstractArt.abstracts.Art;

public class Painting extends Art{
	
	private String paintType;
	
	public Painting(String title, String author, String description, String paintType) {
		// TODO Auto-generated constructor stub
	super(title, author, description);
	this.paintType = paintType;
	}

	@Override
	public void viewArt() {
		// TODO Auto-generated method stub
		System.out.format(" Title: %s \n Author: %s \n Description: %s \n Paint Type: %s \n\n", this.getTitle(), this.getAuthor(), this.getDescription(), this.paintType);
		
	}
	
	

}
