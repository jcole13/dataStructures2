package main;

import java.util.Random;

public class People {
	//instance variables
	public static int number_made = 0;
	private static final int STARTING_ID = 1000;
	private String name;
	private int id; // unique for each person
	private int karma;

	//constructor
	public People(String name){ //constructor
		Random rn = new Random();
		this.name = name;
		this.id = STARTING_ID + number_made;
		number_made++; //incrementing this static variable
		karma = 1; //change this

	}
	//setters and getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString(){ //list facts about a person
		String temp = "Name: " + this.name;
		temp += "\n" + "ID: " + this.id;
		return temp;
	}
	
	public People(){
		this("Anon");
	}


}
