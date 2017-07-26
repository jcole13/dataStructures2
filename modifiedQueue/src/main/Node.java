package main;

public class Node<E> {
	private Node<E> next, previous;
	private E data;
	
	public Node(E e) {
		next = null;
		previous = null;
		data = e;
	}
	public Node<E> getNext() {
		return next;
	}
	public Node<E> getPrevious() {
		return previous;
	}
	public E getData() {
		return data;
	}
	public void setNext(Node<E> n) {
		next = n;
	}
	public void setPrevious(Node<E> n) {
		previous = n;
	}
	public String toString() {
		return data.toString();
	}
}
