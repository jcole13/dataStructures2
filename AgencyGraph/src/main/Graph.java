package main;

public class Graph {
	//instance variables
	private LList allNodes;
	private LList allEdges;
	private LList adjList;
	//constructor
	public Graph() {
		allNodes = new LList();
		allEdges = new LList();
		adjList = new LList();
	}
	public void addNode(GraphNode n){//adds a Graphnode to all nodes and creats a new connection
		allNodes.append(n);
		adjList.append(new LList(n));
	}
	public void addEdge(GraphNode f, GraphNode t){//finds the graphnode and connects two things
		GraphEdge temp = new GraphEdge(f, t);
		allEdges.append(temp);
		Node found = adjList.adjfind(f);
		((LList) found.getData()).append(t);
	}
	public LList getAllNodes(){
		return allNodes;
	}
	public LList getAdjacency() {
		return adjList;
	}
	/**This method uses stacks and searches deep
	 * @param //Graphnode to search for from the first input
	 * @return true or false based on whether it could be found
	 */

	/**This method uses queues and searches wide
	 * @param //GraphNode to search for
	 * @return true or false to answer
	 */
	public boolean Breadth(GraphNode n) {
		//initiate a new Queue
		Queue queue = new Queue();
		GraphNode first = ((LList) adjList.getFirst().getData()).getLabel();
		//start the queue with the start of the search
		queue.join(first);
		first.setVisited(true);
		//goes to search
		while(!queue.isEmpty()) {
			GraphNode g = (GraphNode) queue.leave();//takes the top of the queue
			System.out.println("Leave: " + g);
			if(g.equals(n)) {//yay, the target was removed
				System.out.println("Found: " + g);
				return true;
			}
			Node node = adjList.adjfind(g);//find everything next to the node
			Node gn = ((LList) node.getData()).getFirst();//get everything adjacent
			for(int j = 0; j < ((LList) node.getData()).getLength(); j++) {
				if(!((GraphNode) gn.getData()).getVisited()) {//skip a place
					queue.join(((GraphNode)gn.getData()));
					System.out.println("Join: " + (GraphNode) gn.getData());
					System.out.println("After Joined: " + queue);
					((GraphNode) gn.getData()).setVisited(true);//so there is no overlapping
				}
				gn = gn.getNext();
			}
		}
		return false;//givin up
	}
	public void findPath(){
		//starts at the agency and finds the most people it can
		//connect with using each person's karma points
		//be sure to check if too many karma points for a person,
		//of if there are too many people for karma points
		//we dont want the null pointer exception
		//maybe use a LList of LLists to store everything, or a matrix
		//might be better actually, will ask professor tomorrow
	}
}
