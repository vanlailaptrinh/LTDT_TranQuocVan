package ThucHanhBuoi2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public abstract class Graph {

	protected int vertex;
	protected int[][] adjMatrix;

	public Graph(int vertex) {
		super();
		this.vertex = vertex;
		this.adjMatrix = new int [vertex][vertex	];
	}

	public abstract void addEdge(int u, int v);

	public abstract void removeEdge(int u, int v);

	public abstract int degree(int v);

	public abstract int edges();

	public void print() {
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix.length; j++) {
				System.out.print(this.adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	public void printEdges() {
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix.length; j++) {
				if (this.adjMatrix[i][j] > 0) {
					System.out.print("(" + i + j + "),");
				}
			}
		}
	}
	public static void main(String[] args) {
		UnDirectedGraph gp1 = new UnDirectedGraph(4) ;
		gp1.addEdge(1, 0);
		gp1.print();
		gp1.printEdges();
	}

}