package Matrix;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UnDirectedGraph extends Graph {

	public UnDirectedGraph(int vertex) {
		super(vertex);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addEdge(int u, int v) {
		this.adjMatrix[u][v]++;
		if (u != v) {
			this.adjMatrix[v][u]++;
		}
	}

	@Override
	public void removeEdge(int u, int v) {
		if (this.adjMatrix[u][v] > 0 && this.adjMatrix[v][u] > 0) {
			this.adjMatrix[u][v]--;
			this.adjMatrix[v][u]--;
		}

	}

	@Override
	public int degree(int v) {
		int sum = 0;
		for (int i = 0; i < adjMatrix.length; i++) {
			sum += this.adjMatrix[v][i];
		}
		return sum;
	}

	@Override
	public int edges() {
		int sum = 0;
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix.length; j++) {
				sum += this.adjMatrix[i][j];
			}
		}
		return sum / 2;
	}

	public boolean CheckSingleGraph() {
		for (int i = 0; i < adjMatrix.length; i++) {
			if (this.adjMatrix[i][i] != 0) {
				return false;
			}
		}
		return true;

	}

	public void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[this.adjMatrix.length];
		visited[v] = true;
		queue.add(v);
		System.out.print(v + " ");
		Integer i = v;
		while (!queue.isEmpty()) {
			i = queue.poll();

			for (int j = 0; j < visited.length; j++) {
				if (this.adjMatrix[i][j] != 0) {
					if (visited[j] == false) {
						visited[j] = true;
						queue.add(j);
						System.out.print(j + " ");
					}
				}
			}

		}
	}

	public void DFS(int v) {
	    Stack<Integer> stack = new Stack<>();
	    boolean[] visited = new boolean[this.adjMatrix.length];
	    stack.push(v);

	    while (!stack.isEmpty()) {
	        int currentVertex = stack.pop();
	        if (!visited[currentVertex]) {
	            System.out.print(currentVertex + " ");
	            visited[currentVertex] = true;
	            for (int j = 0; j < visited.length; j++) {
	                if (this.adjMatrix[currentVertex][j] != 0 && !visited[j]) {
	                    stack.push(j);
	                }
	            }
	        }
	    }
	}
	
	public boolean PathExists(int x, int y) {
		if (x==y) {
			return true ;
		}
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[this.adjMatrix.length];
		visited[x] = true;
		queue.add(x);
		Integer i = x;
		while (!queue.isEmpty()) {
			i = queue.poll();

			for (int j = 0; j < visited.length; j++) {
				if (this.adjMatrix[i][j] != 0) {
					if (visited[j] == false) {
						
						if (j==y) {
							return true ;
						}
						else {
							visited[j] = true;
							queue.add(j);
						}
					}
				}
			}

		}
		return false;
	}

	public boolean Conected () {
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix.length; j++) {
				if (!PathExists(i, j)) {
					return false ;
				}
			}
		}
		return true;
	}
	public int countConnectedComponents() {
	    int count = 0;
	    boolean[] visited = new boolean[this.adjMatrix.length];

	    for (int i = 0; i < this.adjMatrix.length; i++) {
	        if (!visited[i]) {
	            DFSUtil(i, visited);
	            count++;
	        }
	    }

	    return count;
	}

	private void DFSUtil(int v, boolean[] visited) {
	    visited[v] = true;

	    for (int j = 0; j < visited.length; j++) {
	        if (this.adjMatrix[v][j] != 0 && !visited[j]) {
	            DFSUtil(j, visited);
	        }
	    }
	}


	public static void main(String[] args) {
		UnDirectedGraph u1 = new UnDirectedGraph(10);
		u1.addEdge(0, 1);
		u1.addEdge(0, 2);
		u1.addEdge(0, 3);
		u1.addEdge(1, 2);
		u1.addEdge(1, 4);
		u1.addEdge(2, 3);
		u1.addEdge(2, 5);
		u1.addEdge(2, 6);
		u1.addEdge(3, 6);
		u1.addEdge(6, 7);
		u1.addEdge(8, 9);

		u1.BFS(0);
		System.out.println("=================");
		u1.DFS(0);
		System.out.println("Dinh 1 , 7 co lien thong : " + u1.PathExists(0, 8) );
		System.out.println(u1.countConnectedComponents());

	}
}
