package main;
import java.util.Random;
public class RandomGraph {
    private RandomGraph(){}//NO INSTANCING!
    public static void main(String [] args){
        RandomGraph.getGraph(100).findPath();
    }
    public static Graph getGraph(int numnodes){ //create a random graph with numnodes nodes
        if(numnodes<10)throw new TooSmallException();
        Graph temp=new Graph();
        GraphNode[] group=new GraphNode[numnodes];
        group[0]=new GraphNode(new People("Agency"));
        group[0].getPerson().setKarma(Integer.MAX_VALUE); //agency is given a lot, irrelevant
        for(int i=1;i<numnodes;i++)group[i]=new GraphNode(new People());
        for(GraphNode p: group)temp.addNode(p);
        Random rng=new Random();
        int chance=(int)(Math.log10(numnodes*numnodes)*numnodes/26*2); //odds
        System.out.println(chance);
        boolean cluster=false;
        for(int i=0;i<group.length-1;i++){
            int counter=0;
<<<<<<< HEAD
            if(!cluster) {
                while (counter < 1) {
                    for (int j = i + 1; j < group.length; j++) {
                        if ((rng.nextInt() % chance) == 2) {
                            System.out.println(group[i] + " is friends with " + group[j]);
                            temp.addEdge(group[i], group[j]);
                            counter++;
                        }
                    }
                }
            }else {
                while (counter < 1) {
=======
            if(!cluster)
             while(counter<1) {
                for (int j = i + 1; j < group.length; j++) {
                    if ((rng.nextInt() % chance) == 2) {
                        System.out.println(group[i] + " is friends with " + group[j]);
                        temp.addEdge(group[i], group[j]);
                        counter++;
                    } //end if
                } //end for
            } //end while
            else
                while(counter<1) {
>>>>>>> 67962c779376c5e6faf5b7d45fd255ff7b39e5e0
                    for (int j = i + 1; j < group.length && counter < 6; j++) {
                        if ((rng.nextInt() % 3) > 1) {
                            System.out.println(group[i] + " is friends with " + group[j]);
                            temp.addEdge(group[i], group[j]);
                            counter++;
                        }
                    }
                    cluster = rng.nextInt() % 6 != 1;
                }
            }
            cluster=cluster||rng.nextInt()%6==2;
        } //end for
        return temp;
<<<<<<< HEAD
    }
    public static Graph getGraph(){
        return getGraph(20);
    }
=======

    } //end getgraph
    public static Graph getGraph(){
        return getGraph(20);
    } //default is 20 nodes

>>>>>>> 67962c779376c5e6faf5b7d45fd255ff7b39e5e0
}
