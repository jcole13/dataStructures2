package main;

public class Node<E> {
	Node<E> next, previous;
	E data;
	
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
	
}
