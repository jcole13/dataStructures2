package main;

public class Node {
	//instance variables
	private Object data;
	private Node next, previous;//double linked list, knows what is before and after
	//constructors
	public Node() {
		data = null;
		next = null;
		previous = null;
	}
	public Node(Object data) {
		this.data = data;
		next = null;
		previous = null;
	}
	//getters and setters, all it is
	public Node getNext() {
		return next;
	}
	public Node getPrevious() {
		return previous;
	}
	public void setNext(Node p) {
		next = p;
	}
	public void setPrevious(Node p) {
		previous = p;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object o){data = o;}
	@Override
	public String toString() {
		return data.toString();
	}
}