package main;

public class People {
	//instance variables
	public static int number_made = 0;
	private static final int STARTING_ID = 1000;
	private String name;
	private final int id; // unique for each person
	private int impatience_total;
	private int impatience_level;
	private int VIP;//the lower the vip level the better
	public People() {//65-90,97-122
		this("");
		name+=(char)(65+Math.random()*26);
		name+=(char)(97+Math.random()*26);
		name+=(char)(97+Math.random()*26);
		name+=(char)(97+Math.random()*26);
		name+=(char)(97+Math.random()*26);

	}
	//constructor
	public People(String name){ //constructor
		this(name,5,Integer.MAX_VALUE);

	} //end constructor
	
	public People(String name, int impatience, int VIP) {
		this.name = name;
		this.id = STARTING_ID + number_made;
		number_made++;
		this.impatience_total = impatience;
		this.VIP = VIP;
		this.impatience_level = 0;
	}
	public People(String name, int impatience) {
		this(name,impatience,Integer.MAX_VALUE);
	}
	//setters and getters
	public String getName() {
		return name;
	} //end get
	public void setName(String name) {
		this.name = name;
	} //end set
	public int getId() {
		return id;
	} //end get
	
	public int getImpatience() {
		return impatience_total;
	}
	
	public int getVIPStatus() {
		return VIP;
	}
	
	public void plusImpatience() {
		impatience_level++;
	}
	
	public boolean checkImpatience() {
		return impatience_level > impatience_total;
	}

	public void minusImpatience() {
		impatience_level--;
	}
	@Override
	public boolean equals(Object o){
		if(!(o instanceof People))return false;
		return this.id==((People) o).getId();
	}
	@Override
	public String toString(){ //list facts about a person
		String temp = "Name: " + this.name;
		temp+=" wait:"+(impatience_total-impatience_level);
		temp += "\t" + "ID: " + this.id;
		return temp;
	} //end toString

} //end class