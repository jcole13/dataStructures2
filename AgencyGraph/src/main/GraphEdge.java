package main;

public class GraphEdge {//this is not really used
	private GraphNode cong, qu;
	public GraphEdge(GraphNode m, GraphNode l) {
		cong = m;
		qu = l;

	} //end constructor
	public String toString() {
		return "from:" + cong + "to:" + qu + "!" ;
	} //end tostring
}
