package main;

public class StackEmptyException extends RuntimeException{//this exception gets hit if either the queue or the stack gets hit
	/**
	 * the following is randomly generated code
	 */
	private static final long serialVersionUID = 2685788240441941748L; //idk

	public StackEmptyException(){//default constructor
		super("Empty");
	} //constructor

}
