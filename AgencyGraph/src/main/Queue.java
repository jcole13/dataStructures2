package main;

public class Queue {
	//instance variables
	private Node front, back;
	private int length;
	public Queue() {
		length = 0;
	}
	/**
	 * 
	 * @param //an object which you wish to store in a node
	 */
	public void join(Object p){ //joins to the back
		Node temp = new Node(p);
		if(isEmpty()){//tests if the queue is null
			back = temp;
			front = back; 
			length++; //philosophically it feels better
		}
		else{
			back.setNext(temp); 
			back = back.getNext();
			length++;
		}
	} //end join
	/**
	 * 
	 * @return the front of the queue
	 */
	public Object leave() { // assumes unlimited data
		//System.out.println("!");
		if (isEmpty())
			throw new StackEmptyException();// TODO make a new Exception
		Object temp = null;
		try {//tests if there is a null pointer, which would be a critical error
		temp = front.getData();
		}catch(NullPointerException npe) {
			System.out.println("Null Pointer");
		}
		front = front.getNext();
		length--;
		return temp;
	} //end leave
	public Object look() {//this peeks at the front of the queue
		return front;
	}
	public boolean isEmpty() {return length == 0;}
	/**@return the top queue in the form of a string
	 * 
	 */
	@Override
	public String toString(){
		String temp = "[";
		Node on = front;
		while(on != null){
			temp += " " + on.getData()+",";
			on = on.getNext();
		}
		return temp.substring(0, temp.length()-1) + "]";
	} //end toString

} //end class
