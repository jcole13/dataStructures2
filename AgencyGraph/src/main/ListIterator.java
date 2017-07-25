package main;

/**
 * Created by Jared Cole on 7/25/2017.
 */
public class ListIterator {
    private Node myNode;

    public ListIterator(Node n) {
        this.myNode = n;
    }

    public Node getNode() {
        return this.myNode;
    }

    public Object getData() {
        if(myNode.getData() != null) System.out.println("This is not null...");
        return this.myNode.getData();
    }

    public void plusplus() {
        this.myNode = this.myNode.getNext();
//check if myNode == null
    }

    public boolean atEnd() {
        return this.myNode == null;
    }

    public ListIterator getNext() {
        return new ListIterator(myNode.getNext());
    }

    public void setdata(Object a) {
        myNode.setData(a);

    }
    public String toString(){
        return myNode.toString();
    }
}
