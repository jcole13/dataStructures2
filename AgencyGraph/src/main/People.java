package main;


public class People {
	//instance variables
	public static int number_made = 0;
	private static final int STARTING_ID = 1000;
	private String name;
	private int id; // unique for each person
	private int karma;
	//constructor
	public People(String name){ //constructor
		this.name = name;
		this.id = STARTING_ID + number_made;
		number_made++; //incrementing this static variable
		karma = 1 + (int)(Math.random() * 5);
	}
	//setters and getters
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public int getKarma(){return karma;}
	public void setKarma(int w){karma = w;}
	public void incrementkarma(){ //used in graph, if person is already seen, to keep loop on track
		karma++;}
	@Override
	public String toString(){ //list facts about a person
		String temp = "Name: " + this.name;
		temp += "\n" + "ID: " + this.id;
		temp += "\n + Karma: " + this.karma;
		return temp;
	}
	public People() {//65-90,97-122 //random names
		this("");
		name+=(char)(65+Math.random()*26);
		name+=(char)(97+Math.random()*26);
		name+=(char)(97+Math.random()*26);
		name+=(char)(97+Math.random()*26);
		name+=(char)(97+Math.random()*26);

	}

}
