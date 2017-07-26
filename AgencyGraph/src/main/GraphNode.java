package main;

public class GraphNode {
	//instance variables
	private final People label;
	private boolean visited; //check if search reached it
	private boolean settled;
	private boolean clustervisited;
	private int numOfConnections;
	//constructor
	public GraphNode(People p) {
		label = p;
		visited = false;
		settled = false;
		clustervisited = false;
		
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
	public boolean getClusterVisited(){return clustervisited;}
	public void setClustervisited(boolean bool){clustervisited = bool;}
	/**An incorrect override
	 * @param //Takes a graphnode to compare this to
	 * @return true or false based on the name
	 */
	public boolean equals(GraphNode n) {
		return this.label.getName().equals(n.getPerson().getName());
	} //check equal names
	@Override
	public String toString() {
		return label.getName();
	} //tostring
}
