package main;

public class Queue<E> {
	//instance variables
	private Node<E> front, back;
	private int length;
	/**
	 * these are the constructors
	 * @param
	 */
	public Queue() {
		length = 0; 
	} //end constructor
	/**
	 * 
	 * @param //an object which you wish to store in a node
	 * @throws QueueEmptyException 
	 */
	public void join(E e) throws QueueEmptyException{
		Node<E> temp = new Node<>(e);
		System.out.println("Adding person to the back...");
		if(isEmpty()){//tests if the queue is null
			back = temp;
			front = back; 
			length++; //philosophically it feels better
		} //end if
		else{
			back.setNext(temp);
			temp.setPrevious(back);
			back = back.getNext();
			incrementImpatience();
			length++;
		} //end else
	} //end join
	/**
	 * @return the front of the queue
	 * @throws QueueEmptyException 
	 */
	public E leave() throws QueueEmptyException { // assumes unlimited data
		if (isEmpty()) throw new QueueEmptyException();// TODO make a new Exception
		E temp = null;
		System.out.println("Front person is leaving...");
		try {//tests if there is a null pointer, which would be a critical error
		temp = front.getData();
		}catch(NullPointerException npe) {
			System.out.println("Null Pointer");
		}
		//System.out.println("HERE IS THE PERSON WHO LEAVES!!! " + temp);
		front = front.getNext();
		front.setPrevious(null);
		//System.out.println("Someone has left");
		length--; //decrement length if leave
		decrementImpatience();//if people leave, their impatience decreases
		//System.out.println("HERE IS THE PERSON WHO LEAVES!!! " + temp);
		return temp;
	} //end leave
	public E look() {//this peeks at the front of the queue
		return front.getData();
	} //end look
	public void insertVIP(E e) throws QueueEmptyException {//takes more overhead than just regularly joining
		System.out.println("Inserting a VIP at position" + ((People)e).getVIPStatus());
		if(length <= ((People) e).getVIPStatus()) { //casted
			join(e);
			return;
		}
		Node<E> i = front;
		int j = 0;
		System.out.println(this);
		boolean outer=true;
		while(i != null&&outer) {
			if(j++ >= ((People) e).getVIPStatus()) { //cast
				Node<E> temp = new Node<E>(e);
				temp.setNext(i.getNext());
				i.getNext().setPrevious(temp);
				i.setNext(temp);
				temp.setPrevious(i);
				length++;
				outer=false;
			}
			i = i.getNext();
		}
		this.incrementImpatience();
	} // end insertVIP
	public Node<E> find(Node<E> n) {
		Node<E> i = front;
		do{
			if(((People) i.getData()).getId() == ((People) n.getData()).getId()) return i;//where to break off //cast
			i = i.getNext();
		}while(i != null);
		return null;
	}
	public boolean isEmpty() {return length == 0;} //end isempty
	public int getLength(){return length; }

	@Deprecated
	public Node<E> findByID(int id) {//returns the node
		Node<E> i=front;
		while(i!=null) {
			if(((People)i.getData()).getId()==id)return i;
			i=i.getNext();
		}
		return null;
	}
	@Deprecated
	public Node<E> findByName(String name) {//returns the node
		Node<E> i=front;
		while(i!=null) {
			if(((People)i.getData()).getName()==name)return i;
			i=i.getNext();
		}
		return null;
	}
	private void incrementImpatience() throws QueueEmptyException {
		Node<E> i = front;
		//boolean removed = false;
		while(i != null) {
			((People) i.getData()).plusImpatience(); //cast
			if(((People) i.getData()).checkImpatience()) { //cast
				System.out.println("Impatient person leaving\n"+i);
				leaveFromMiddle(i);
				//removed = true;
				//counter++;
			}
			i = i.getNext();
			
		}
	} //end incrementImpatience
	private void decrementImpatience() {
		Node<E> i = front.getNext();
		while(i != null) {
			//System.out.println("Loop");
			((People) i.getData()).minusImpatience(); //cast
			i = i.getNext();
		}
	} //end incrementImpatience
	/**@return the top queue in the form of a string
	 * 
	 */
	@Override
	public String toString(){
		String temp = "[";
		Node<E> on = front;
		while(on != null){
			temp += " " + on.getData()+",";
			on = on.getNext();
		} //end while
		return temp.substring(0, temp.length()-1) + "]";
	}//end toString
	private E leaveFromMiddle(Node<E> n) throws QueueEmptyException {
		//increment impatience level when adding anything
		//in increment, add a condition to leave?

		if (isEmpty()) throw new QueueEmptyException();// TODO make a new Exception
		Node<E> temp = n;
		if(temp.getPrevious() != null) {
			temp.getPrevious().setNext(temp.getNext());
			temp.getNext().setPrevious(temp.getPrevious());
			length--;
		} else {
			System.out.println("Why would the first person in line leave...");
		}
		return temp.getData();
	}

} //end class