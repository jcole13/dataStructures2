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

	/*public void findMostNodes() {
		//initiate a new Queue
		Queue queue = new Queue();
		GraphNode agency = ((LList) adjList.getFirst().getData()).getLabel();//agency
		queue.join(agency);
		agency.setVisited(true);
		agency.setSettled(true);
		LList settledNodes = new LList();

		while(!queue.isEmpty()){
			GraphNode g = (GraphNode) queue.leave();
			Node node = adjList.adjfind(g);
			Node gn = ((LList) node.getData()).getFirst();//first node in second level LList
			LList currentConnections = ((LList) node.getData());
			if(currentConnections.getLength() == 1){
				settledNodes.append(((LList) node.getData()).getLabel());
				((LList) node.getData()).getLabel().setSettled(true);
				queue.join((GraphNode)currentConnections.getFirst().getData());
				//settledNodes.append(currentConnections.getFirst().getData());
				//((GraphNode) currentConnections.getFirst().getData()).setSettled(true);
			}
			else if(currentConnections.getLength() < 1){
				System.out.println("No Connections to this node");
				settledNodes.append(((LList) node.getData()).getLabel());
				((LList) node.getData()).getLabel().setSettled(true);
			}
			else {
				for (int i = 0; i < currentConnections.getLength(); i++) {
					if (((GraphNode) gn.getData()).getPerson().getKarma() > 0) {
						if(!((GraphNode) gn.getData()).getVisited()) {
							queue.join(gn.getData());
							((GraphNode) gn.getData()).setVisited(true);
						}

					}

				}
			}
		}//end while
		//definition of cluster, a lot of interconnected nodes

		Node i = settledNodes.getFirst();
		while(i != null){
			addEdge(agency, (GraphNode)i.getData());
		}
		/*GraphNode first = ((LList) adjList.getFirst().getData()).getLabel();
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
			int currentKarma = ((LList) node.getData()).getLabel().getPerson().getKarma();
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
		//return false;//givin up
	}*/

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
			System.out.println("Current" + current);
			LList currentnodes = (LList)adjList.adjfind(current).getData();
			Node a = currentnodes.getFirst();
			System.out.println(a);
			int i = 0;
			while(i < current.getPerson().getKarma() && a != null){
				if(!((GraphNode)a.getData()).getVisited()) {
					queue.join((GraphNode) a.getData());
					((GraphNode) a.getData()).setVisited(true);
					addEdge(agency, (GraphNode) a.getData());
					System.out.println("Edge added from agency to: " + (GraphNode) a.getData());
				}
				else{ //only if the node is already seen, so karma is not wasted looking at the node
					current.getPerson().incrementkarma();}
				i++;
				a = a.getNext();
			}
		}



	}
	private LList chooser(LList llist, int karma){//first maybe the most connections, then maybe those that have not yet been added or those that have not yet been infected

		return null;
	}
}
