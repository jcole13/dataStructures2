package main;

public class GraphEdge {//this is not really used
	private GraphNode cong, qu;
	public GraphEdge(GraphNode m, GraphNode l) {
		cong = m;
		qu = l;

	}
	public String toString() {
		return "from:" + cong + "to:" + qu + "!" ;
	}
}
