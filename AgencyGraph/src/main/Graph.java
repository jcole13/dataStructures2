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
		f.incrementConnections();
		Node found = adjList.adjfind(f);
		((LList) found.getData()).append(t);
	} //end addedge
	public LList getAllNodes(){
		return allNodes;
	}
	public LList getAdjacency() {
		return adjList;
	}



	public int findPath(){ //finds the path that touches the most nodes, using a bfs
		int counter = 0;
		Queue queue = new Queue(); //bfs
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
				if(!((GraphNode)a.getData()).getVisited()) { //only interested in new nodes
					queue.join((GraphNode) a.getData());
					((GraphNode) a.getData()).setVisited(true);
					addEdge(agency, (GraphNode) a.getData());
					System.out.println();
					System.out.println("Edge added from agency to: " + (GraphNode) a.getData());
					counter++;
					System.out.println();
				}
				else{ //only if the node is already seen, so karma is not wasted looking at the node
					current.getPerson().incrementkarma();}
					//System.out.println(((GraphNode) a.getData()) + " has aleady been connected to...");
				i++; //loop
				a = a.getNext(); //other loop
			} //end while
		} //end while
		return counter;


	} //end findpath

	public void findCluster(){ //working on it
		LList possibilities = prunebyEdges();
		separateClusters(possibilities);
		System.out.println("Here are the GraphNodes with 4 or more edges: " + possibilities);

	}

	private LList prunebyEdges(){ //bfs, check if 4 or more edges. if so, add to an llist (new)
		Queue queue = new Queue();
		LList candidates = new LList();
		GraphNode first = ((LList) adjList.getFirst().getData()).getLabel();
		//start the queue with the start of the search
		queue.join(first);
		first.setClustervisited(true);

		//goes to search
		while(!queue.isEmpty()) {
			GraphNode g = (GraphNode) queue.leave();//takes the top of the queue
			System.out.println("Leave: " + g);
			System.out.println("Connections: " + g.getNumOfConnections());
			if(g.getNumOfConnections() >= 4) {//yay possible cluster
				candidates.append(g);
			}
			Node node = adjList.adjfind(g);//find everything next to the node
			Node gn = ((LList) node.getData()).getFirst();//get everything adjacent
			for(int j = 0; j < ((LList) node.getData()).getLength(); j++) {
				if(!((GraphNode) gn.getData()).getVisited()) {//skip a place
					queue.join(((GraphNode)gn.getData()));
					System.out.println("Join: " + (GraphNode) gn.getData());
					System.out.println("After Joined: " + queue);
					((GraphNode) gn.getData()).setClustervisited(true);//so there is no overlapping
				}
				gn = gn.getNext(); //next node
			}//end for
		} //end while
			return candidates;
	} //end prunebyEdges

	private void separateClusters(LList candidates){

	}
} //end class
