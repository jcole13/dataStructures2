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
	} //end constructor
	public void addNode(GraphNode n){//adds a Graphnode to all nodes and creats a new connection
		allNodes.append(n);
		adjList.append(new LList(n));
	} //end addnode
	public void addEdge(GraphNode f, GraphNode t){//finds the graphnode and connects two things
		GraphEdge temp = new GraphEdge(f, t);
		allEdges.append(temp);
		Node found = adjList.adjfind(f);
		((LList) found.getData()).append(t);
	} //end addedge
	public LList getAllNodes(){
		return allNodes;
	}
	public LList getAdjacency() {
		return adjList;
	}



	public void findPath(){
		Queue queue = new Queue();
		GraphNode agency = ((LList) adjList.getFirst().getData()).getLabel();//agency
		Node first = ((LList) adjList.getFirst().getData()).getFirst();
		queue.join(agency);
		agency.setVisited(true);
		agency.setSettled(true);
		System.out.println("Before first while");
		while(first != null){
			queue.join(((GraphNode)first.getData()));
			((GraphNode)first.getData()).setVisited(true);
			first = first.getNext();
		}
		System.out.println(queue);

		while(!queue.isEmpty()){
			GraphNode current = (GraphNode)queue.leave();
			//System.out.println("Current" + current);
			LList currentnodes = (LList)adjList.adjfind(current).getData();
			//LList currentShortenedNodes = chooser(currentnodes,current.getPerson().getKarma());
			//System.out.println("Current Nodes: " + currentnodes);
			//System.out.println("Chooser Nodes: " + currentShortenedNodes);
			//System.out.println("Before sort" + currentnodes);
			System.out.println("Current Node: "+ current);
			currentnodes.sort();
			System.out.println("Neighbor nodes ordered in optimal way: " + currentnodes);
			Node a = currentnodes.getFirst();
			//System.out.println(a);
			int i = 0;
			System.out.println(current.getPerson().getName() +" has " + current.getPerson().getKarma() + " karma");
			while(i < current.getPerson().getKarma() && a != null){
				if(!((GraphNode)a.getData()).getVisited()) {
					queue.join((GraphNode) a.getData());
					((GraphNode) a.getData()).setVisited(true);
					addEdge(agency, (GraphNode) a.getData());
					System.out.println("Edge added from agency to: " + (GraphNode) a.getData());
				}
				else{ //only if the node is already seen, so karma is not wasted looking at the node
					current.getPerson().incrementkarma();}
					//System.out.println(((GraphNode) a.getData()) + " has aleady been connected to...");
				i++;
				a = a.getNext();
			} //end while
		} //end while



	} //end findpath
} //end class
