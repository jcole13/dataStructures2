package main;
import org.junit.*;
import static org.junit.Assert.*;
public class Tests {
    @Test
    public void testImpatience(){
        Queue<People> line= new Queue<>();
        for(int i=0;i<10;i++)line.join(new People());//randomly generated
        assertEquals("People should be 6 in line, as the default 5 impatience(-1 for each person), but first doesn't leave",6,line.getLength());

    }
    @Test
    public void testleave(){
        Queue<People> line= new Queue<>();
        for(int i=0;i<10;i++)line.join(new People());//randomly generated
        line.leave();
        assertEquals("after one person served",5,line.getLength());
        line.join(new People("Hiro!",10));
        assertEquals("No Person should leave, as patience was served!",6,line.getLength());
        for(int i=0;i<5;i++){
            line.leave();
        }
        assertEquals("After 5 leaving, there should be one left(hiro!)",1,line.getLength());
    }
    @Test
    public void testJoin(){
        Queue<People> line= new Queue<>();
        for(int i=0;i<10;i++)line.join(new People());//randomly generated
        line.leave();
        assertEquals("after one person served",5,line.getLength());
        line.join(new People("Hiro!",10));
        for(int i=0;i<5;i++){
            line.leave();
        }
        assertEquals("After 5 leaving, there should be one left(hiro!)",1,line.getLength());
    }
    @Test
    public void testAdd(){
        Queue<People> line= new Queue<>();
        for(int i=0;i<10;i++)line.join(new People());//randomly generated
        line.leave();
        line.insertVIP(new People("Hiro!",10,6));
        assertEquals("No Person should leave, and vip should be added",6,line.getLength());
            }

}
