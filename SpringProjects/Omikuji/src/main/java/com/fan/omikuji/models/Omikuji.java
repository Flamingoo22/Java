package com.fan.omikuji.models;

public class Omikuji {
	private Integer num;
	private String location;
	private String person;
	private String hobby;
	private String thing;
	private String message;
	public Omikuji() {
		// TODO Auto-generated constructor stub
	}
	public Omikuji(Integer num, String location, String person, String hobby, String thing, String message) {
		super();
		this.num = num;
		this.location = location;
		this.person = person;
		this.hobby = hobby;
		this.thing = thing;
		this.message = message;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getThing() {
		return thing;
	}
	public void setThing(String thing) {
		this.thing = thing;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
