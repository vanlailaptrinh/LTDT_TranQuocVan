package Matrix;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Graph {

	protected int[][] adjMatrix;

	

	public Graph(int [][] adjMatrix) {
		
		this.adjMatrix = new int [adjMatrix.length][adjMatrix.length];
	}

	public abstract void addEdge(int u, int v);

	public abstract void removeEdge(int u, int v);

	public abstract int degree(int v);

	public abstract int edges();
	
	public abstract Graph copy() ;
	
	public abstract boolean hasEdge (int i, int j) ;
	
	public abstract boolean CheckEuler() ;
	
	public abstract boolean CheckHalfEuler() ;
	
	public abstract  List<Integer> ProcessEuler(Integer s);
	
	public abstract boolean PathExists(int x, int y) ;
	
	public abstract boolean Conected() ;
 	

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
		
	}

	
	

}
