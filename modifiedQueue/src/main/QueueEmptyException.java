package main;

public class QueueEmptyException extends Exception {
	public QueueEmptyException() {
		super("Queue is empty");
	}
}
