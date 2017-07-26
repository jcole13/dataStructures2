package main;

public class TooSmallException extends RuntimeException{
    public TooSmallException(){
        super("There were too few nodes decided to add (need more than 10)");
    }
}
