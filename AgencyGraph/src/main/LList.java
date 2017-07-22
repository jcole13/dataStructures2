package main;

public class LList {
	//instance variables
	private GraphNode label;
	private Node header, back;
	private int length;
	//constructors
	public LList() {
		label = null;
		header = new Node();
		length = 0;
	}
	public LList(GraphNode o) {
		label = o;
		header = new Node();
		length = 0;
	}
	//setters and getters
	public Node getFirst() {
		return header.getNext();
	}
	public int getLength() {
		return length;
	}
	public GraphNode getLabel() {
		return label;
	}
	public boolean isEmpty(){ 
		return this.length == 0;
	}
	/**
	 * 
	 * @param object which to add to the back of the list
	 */
	public void append(Object p){
		if(isEmpty()) {//checks if the list is empty to avoid a nullpointer
			Node temp = new Node(p);
			header.setNext(temp);//switching
			temp.setPrevious(header);
			back = header.getNext();
			length++;
			
		}else{
			Node temp = new Node(p);
			back.setNext(temp);
			temp.setPrevious(back);//switching the back to the 
			back = back.getNext();
			length++;
		}

	}
	/**Overloaded method
	 * @param it needs a graphnode, but it is for a specific usage of the adjacency list
	 * @return returns a node within the graphnode, or a null if it cannot be found
	 */
	public Node adjfind(GraphNode n) { //use for adjacency list
		Node i = header.getNext();
		do{
			if(((LList) i.getData()).getLabel().equals(n)) return i;//where to break off
			i = i.getNext();
		}while((i.getData() != null) && !(((LList) i.getData()).equals(n)));
		return null;
	}
	/**Overloaded method
	 * @param String to find the specific GraphNode
	 * @return a GraphNode with the name
	 */
	public GraphNode gnFind(String s) {
		Node i = header.getNext();
		do{
			if(((LList) i.getData()).getLabel().getPerson().getName().equals(s)) {
				return ((LList) i.getData()).getLabel();
			}
			i = i.getNext();
		}while((i.getData() != null)); //gives graphnode from string 
		
		System.out.println("Exited Loop");
		
		return null;
		
	}
	@Override
	public String toString() {
		Node temp = header.getNext();
		String result = "";
		while(temp != null) {
			result += " " + temp.toString();
			temp = temp.getNext();
		}
		//if(label != null) return label.toString();
		return result;
	}
}
