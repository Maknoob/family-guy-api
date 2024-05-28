package com.codingmak.familyguyapi.Model;

public class CharacterModel {
	
	private int id;
	private String name;
	private int age;
	private String from;
	private String workPlace;
	private String family;
	
	public CharacterModel(int id, String name, int age, String from, String workPlace, String family) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.from = from;
		this.workPlace = workPlace;
		this.family = family;
	}
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getFrom() {
		return from;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public String getFamily() {
		return family;
	}
	


}
