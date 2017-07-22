package main;

public class Tester {
	
	
	public static void main(String[] args) throws QueueEmptyException {
	Queue<People> queue = new Queue<People>();
		
		System.out.println();
		queue.join(new People("John", 11));
		queue.join(new People("Jane", 3));
		queue.join(new People("Jose", 5));
		queue.join(new People("Jynn", 7));
		queue.join(new People("Jhin", 4));
		queue.join(new People("Jones", 6));
		queue.join(new People("Johnny", 3));
		queue.join(new People("Jojo", 12));
		queue.join(new People("Jizz", 9));
		queue.insertVIP(new People("Hugo",3,2));
		queue.insertVIP(new People("Holt",5,4));
		queue.insertVIP(new People("Hans",6,4));
		System.out.println();
	System.out.println(queue);
}
	

}
