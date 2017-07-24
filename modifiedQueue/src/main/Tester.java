package main;

public class Tester {
	
	
	public static void main(String[] args) throws QueueEmptyException {
	Queue<People> queue = new Queue<People>();
		
		System.out.println();
		queue.join(new People("John", 20));
		System.out.println("\t" + queue);
		queue.leave();
		queue.join(new People("Jane", 3));
		//queue.leave();
		System.out.println("\t" + queue);
		//queue.leave();
		queue.join(new People("Jose", 4));
		System.out.println("\t" + queue);
		//queue.leave();
		queue.join(new People("Jynn", 7));
		System.out.println("\t" + queue);
		queue.join(new People("Jhin", 4));
		System.out.println("\t" + queue);
		queue.join(new People("Jones", 6));
		System.out.println("\t" + queue);
		queue.join(new People("Johnny", 3));
		System.out.println("\t" + queue);
		queue.join(new People("Jojo", 12));
		System.out.println("\t" + queue);
		queue.join(new People("Jazz", 9));
		System.out.println("\t" + queue);
		queue.insertVIP(new People("Hugo",2,2));
		queue.insertVIP(new People("Holt",5,4));
		queue.insertVIP(new People("Hans",6,4));
		System.out.println();
	System.out.println(queue);
}
	

}
