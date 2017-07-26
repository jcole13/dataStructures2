package main;
import java.util.Random;
public class RandomGraph {
    private RandomGraph(){}//NO INSTANCING!
    public static void main(String [] args){
        RandomGraph.getGraph(100).findPath();
    }
    public static Graph getGraph(int numnodes){
        if(numnodes<10)throw new TooSmallException();
        Graph temp=new Graph();
        GraphNode[] group=new GraphNode[numnodes];
        group[0]=new GraphNode(new People("Agency"));
        group[0].getPerson().setKarma(Integer.MAX_VALUE);
        for(int i=1;i<numnodes;i++)group[i]=new GraphNode(new People());
        for(GraphNode p: group)temp.addNode(p);
        Random rng=new Random();
        int chance=(int)(Math.log10(numnodes*numnodes)*numnodes/26);
        System.out.println(chance);
        for(int i=0;i<group.length-1;i++){
            int counter=0;
            while(counter<1) {
                for (int j = i + 1; j < group.length && counter < 4; j++) {
                    if ((rng.nextInt() % chance) == 2) {
                        System.out.println(group[i] + " is friends with " + group[j]);
                        temp.addEdge(group[i], group[j]);
                        counter++;
                    }
                }
            }
        }
        return temp;

    }
    public static Graph getGraph(){
        return getGraph(20);
    }

}
