package main;

public class Tester {
	
	
	public static void main(String[] args) throws QueueEmptyException {
	Queue<People> queue = new Queue<People>();
		
		System.out.println();
		queue.join(new People("John", 10, 100));
		queue.join(new People("John", 3, 100));
		queue.join(new People("John", 5, 100));
		queue.join(new People("John", 7, 100));
		queue.join(new People("John", 4, 100));
		queue.join(new People("John", 6, 100));
		queue.join(new People("John", 3, 100));
		queue.join(new People("John", 12, 100));
		queue.join(new People("John", 9, 100));
		System.out.println();
	System.out.println(queue);
}
	

}
