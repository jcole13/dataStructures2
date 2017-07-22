package main;

public class GraphEdge {//this is not really used
	private GraphNode cong, qu;
	private int karma;
	public GraphEdge(GraphNode m, GraphNode l) {
		cong = m;
		qu = l;
		karma=1+(int)Math.random()*3;
	}
	public GraphEdge(GraphNode m, GraphNode l, int karma) {
		cong=m;qu=l;this.karma=karma;
	}
	public String toString() {
		return "from:"+cong+"to:"+qu+"!"+karma;
	}
	public boolean useable() {
		return (--karma<=0);
	}
}
