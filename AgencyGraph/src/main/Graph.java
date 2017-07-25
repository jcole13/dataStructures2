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
			//LList currentShortenedNodes = chooser(currentnodes,current.getPerson().getKarma());
			//System.out.println("Current Nodes: " + currentnodes);
			//System.out.println("Chooser Nodes: " + currentShortenedNodes);
			System.out.println(currentnodes);
			currentnodes.sort();
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
	/*private void reorganize(LList llist, int karma){//sort by min(karma, connection length) should be from max to min
		if(llist.getLength()<karma)return;

		Node first = llist.getFirst();
		Node current = llist.getFirst();
		while(first != null){
			if()
			current = current.getNext();
		}


		/*Node[] data=new Node[llist.getLength()];
		Node temp=llist.getFirst();
		for(int i=0;i<data.length;i++){
				data[i] = temp;
				temp = temp.getNext();
		}*/

		/*if(data.length>karma) {
			//sort
			for (int i = 0; i < data.length - 1; i++) {
				int max = i;
				for (int j = i + 1; j < data.length; j++) {
					if(Math.min(((GraphNode)data[j].getData()).getPerson().getKarma(),((LList)adjList.adjfind(((GraphNode)data[j].getData())).getData()).getLength()) > (Math.min(((GraphNode)data[i].getData()).getPerson().getKarma(),((LList)adjList.adjfind(((GraphNode)data[i].getData())).getData()).getLength()))){
						max = j;
					} //end if

				}
				Node t = data[i];
				data[max] = data[i];
				data[i] = temp;

			}
		}
		LList ret=new LList();
		for(int i=0;i<data.length;i++){
			ret.append(data[i]);
		}
		return ret;
	}*/
} //end class
