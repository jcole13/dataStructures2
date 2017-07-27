package main;

public class GraphEdge implements Comparable<GraphEdge>{//this is not really used
	private GraphNode cong, qu;
	public GraphEdge(GraphNode m, GraphNode l) {
		cong = m;
		qu = l;

	} //end constructor
	@Override
	public String toString() {
		return "from:" + cong + "to:" + qu + "!" ;
	} //end tostring

	@Override
	public int compareTo(GraphEdge o) {
		if(this.cong==o.cong){
			if(this.qu==o.qu)return 0;
			else return 1;
		}else{
			return -1;
		}
	}
}
