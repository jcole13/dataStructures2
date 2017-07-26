package main;

public class Runner {//the runner is the main method for all
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//UI ui = new UI();
		//ui.UserInput();
		Graph g = new Graph();
		//These are the the initiation for all the nodes. just for now, testing
		GraphNode Agency = new GraphNode(new People("Agency"));
		GraphNode A = new GraphNode(new People("A"));
		GraphNode B = new GraphNode(new People("B"));
		GraphNode C = new GraphNode(new People("C"));
		GraphNode D = new GraphNode(new People("D"));
		GraphNode E = new GraphNode(new People("E"));
		GraphNode F = new GraphNode(new People("F"));
		GraphNode G = new GraphNode(new People("G"));
		GraphNode H = new GraphNode(new People("H"));
		GraphNode I = new GraphNode(new People("I"));
		GraphNode J = new GraphNode(new People("J"));
		GraphNode K = new GraphNode(new People("K"));
		GraphNode L = new GraphNode(new People("L"));
		GraphNode M = new GraphNode(new People("M"));
		GraphNode N = new GraphNode(new People("N"));
		GraphNode O = new GraphNode(new People("O"));
		GraphNode P = new GraphNode(new People("P"));
		GraphNode Q = new GraphNode(new People("Q"));
		GraphNode R = new GraphNode(new People("R"));
		GraphNode S = new GraphNode(new People("S"));
		GraphNode T = new GraphNode(new People("T"));
		GraphNode U = new GraphNode(new People("U"));
		GraphNode V = new GraphNode(new People("V"));
		GraphNode W = new GraphNode(new People("W"));
		GraphNode X = new GraphNode(new People("X"));
		GraphNode Y = new GraphNode(new People("Y"));
		GraphNode Z = new GraphNode(new People("Z"));
		//these add all of the nodes to the graph
		g.addNode(Agency);
		g.addNode(A);
		g.addNode(B);
		g.addNode(C);
		g.addNode(D);
		g.addNode(E);
		g.addNode(F);
		g.addNode(G);
		g.addNode(H);
		g.addNode(I);
		g.addNode(J);
		g.addNode(K);
		g.addNode(L);
		g.addNode(M);
		g.addNode(N);
		g.addNode(O);
		g.addNode(P);
		g.addNode(Q);
		g.addNode(R);
		g.addNode(S);
		g.addNode(T);
		g.addNode(U);
		g.addNode(V);
		g.addNode(W);
		g.addNode(X);
		g.addNode(Y);
		g.addNode(Z);
		//these add random nodes. starting from a
		g.addEdge(Agency, A);
		g.addEdge(A, B);
		g.addEdge(A, C);
		g.addEdge(C, D);
		g.addEdge(B, E);
		g.addEdge(E, F);
		g.addEdge(D, F); //ADD EDGES
		g.addEdge(F, Z);
		g.addEdge(E, G);
		g.addEdge(B, X);
		g.addEdge(D, P);
		g.addEdge(S, C);
		g.addEdge(G, I);
		g.addEdge(H, Y);
		g.addEdge(I, J);
		g.addEdge(J, Z);
		g.addEdge(K, L);
		g.addEdge(L, O);
		g.addEdge(M, V);
		g.addEdge(N, A);
		g.addEdge(O, Q);
		g.addEdge(P, Z);
		g.addEdge(Q, X);
		g.addEdge(R, B);
		g.addEdge(S, H);
		g.addEdge(T, D);
		g.addEdge(U, E);
		g.addEdge(V, U);
		g.addEdge(W, Y);
		g.addEdge(X, G);
		g.addEdge(Y, I);
		g.addEdge(Z, K);
		g.addEdge(Q, W);
		g.addEdge(W, M);
		g.addEdge(M, N);
		g.addEdge(N, R);
		g.addEdge(X, S);
		g.addEdge(S, T);
		g.addEdge(K, U);
		//g.findPath();
		Graph q = new Graph();
		q.addNode(Agency);
		q.addNode(A);
		q.addNode(B);
		q.addNode(C);
		q.addNode(D);
		q.addNode(E);
		q.addNode(X);
		q.addEdge(Agency, A);
		q.addEdge(A, C);
		q.addEdge(A, X);
		q.addEdge(A, B);
		q.addEdge(C, D);
		q.addEdge(C, E);
		q.addEdge(Agency, X);

		A.getPerson().setKarma(2);
		B.getPerson().setKarma(1);
		C.getPerson().setKarma(1);
		D.getPerson().setKarma(2);
		E.getPerson().setKarma(3);
		//q.findPath();

		Graph a = new Graph();
		a.addNode(Agency);
		a.addNode(A);
		a.addNode(B);
		a.addNode(C);
		a.addNode(D);
		a.addNode(E);
		a.addNode(F);
		a.addNode(G);
		a.addEdge(Agency, A);
		a.addEdge(A, C);
		a.addEdge(A, D);
		a.addEdge(A, E);
		a.addEdge(E, F);
		a.addEdge(C, G);
		a.findPath();






	}
}
