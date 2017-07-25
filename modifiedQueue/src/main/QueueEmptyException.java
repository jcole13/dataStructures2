package main;

public class QueueEmptyException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8863245186454741375L;

	public QueueEmptyException() {
		super("Queue is empty");
	}
}
