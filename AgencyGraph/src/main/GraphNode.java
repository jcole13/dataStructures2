package main;

public class GraphNode {
	//instance variables
	private People label;
	private boolean visited; //check if search reached it
	private boolean settled;
	private int numOfConnections;
	//constructor
	public GraphNode(People p) {
		label = p;
		visited = false;
		settled = false;
		
	} //end constructor
	//getters and setters
	public People getPerson() {
		return label;
	}
	public boolean getVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public boolean getSettled(){return settled;}
	public void setSettled(boolean settled){this.settled = settled;}
	public int getNumOfConnections(){return numOfConnections;}
	public void incrementConnections(){numOfConnections++;}
	/**An incorrect override
	 * @param //Takes a graphnode to compare this to
	 * @return true or false based on the name
	 */
	public boolean equals(GraphNode n) {
		return this.label.getName().equals(n.getPerson().getName());
	} //check equal names
	public boolean greaterThan(GraphNode n){
		return this.getPerson().getKarma() > n.getPerson().getKarma();
	} //check if the first one has a greater karma than the second
	@Override
	public String toString() {
		return label.getName();
	} //tostring
}
