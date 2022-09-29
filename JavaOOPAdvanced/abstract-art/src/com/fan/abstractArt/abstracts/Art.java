package com.fan.abstractArt.abstracts;

public abstract class Art {
	private String title;
	private String author;
	private String description;
	
	public Art () {
	}
	
	public Art(String title, String author, String description) {
		// TODO Auto-generated constructor stub
		this.title= title;
		this.author = author;
		this.description = description;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public abstract void viewArt();

}
