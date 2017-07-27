package main;

/**
 * Created by Jared Cole on 7/26/2017.
 */
public class Tester {
    public static void main(String[] args) {

        intro();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        Queue queue = new Queue();
        queue.insertVIP(new People("King", 10, 3));
        System.out.println(queue);
        queue.join(new People("Jad", 2, 2));
        System.out.println(queue);
        queue.join(new People("Jimmy", 6, 2));
        System.out.println(queue);
        queue.join(new People("Jack", 10, 2));
        System.out.println(queue);
        queue.leave();
        System.out.println(queue);
        queue.join(new People("Jared", 5, 2));
        System.out.println(queue);
        queue.join(new People("Jay", 3, 2));
        System.out.println(queue);
        queue.join(new People("Jerry", 7, 2));
        queue.leave();
        System.out.println(queue);
        queue.join(new People("Jon", 20, 2));
        System.out.println(queue);
        queue.join(new People("Jane", 2, 2));
        queue.leave();
        System.out.println(queue);
        queue.join(new People("Jazz", 6, 2));
        System.out.println(queue);
        queue.join(new People("Jin", 2, 2));
        System.out.println(queue);

        queue.insertVIP(new People("Richard", 10, 3));

        BST searcher = new BST();
        //searcher.insert(new People("John", 1, 1));
        Node first = queue.getfirst();
        while(first != null){
            searcher.insert((People)first.getData());
            first = first.getNext();
        }
        System.out.println(searcher);
        System.out.println("Found: " + searcher.find("Richard"));


        //System.out.println(queue);

    }

    public static void intro(){
        System.out.println("#################################################################################################################");
        System.out.println("Welcome to the modified queue");
        System.out.println("This is a simulation of people waiting in line");
        System.out.println();
        System.out.println("Typical of a queue, people generally enter from the back and are served from the front");
        System.out.println("However, in this queue, we have 'modified' the queue in order to make things more interesting");
        System.out.println();
        System.out.println("Each person in the queue has a field called 'impatience_total' and 'VIP_Status'");
        System.out.println("Each time a person is added to the line, impatience level in each person rises");
        System.out.println("And every time a person is served, that impatience level is decremented");
        System.out.println();
        System.out.println("If the impatience level surpasses the total, the person leaves from the middle of the line (wait = -1)");
        System.out.println("Of course, the first person will not leave like that because why would you if you are already at the front");
        System.out.println();
        System.out.println("VIP Insert works in such a way that if the method is called, the person is added into the index");
        System.out.println("That their private field indicates. ");
        System.out.println("if the index is greater than the length of the line, they are added to the back");
        System.out.println();
        System.out.println("The other join and leave methods work as normal");
        System.out.println();
        System.out.println("We hope you enjoy!");
        System.out.println("#################################################################################################################");
    }
}
