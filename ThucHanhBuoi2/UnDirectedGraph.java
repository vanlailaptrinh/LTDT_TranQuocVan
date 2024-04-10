package Matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class UnDirectedGraph extends Graph {

	

	public UnDirectedGraph(int[][] adjMatrix) {
		super(adjMatrix);
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

	@Override
	public boolean PathExists(int x, int y) {
		if (x == y) {
			return true;
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

						if (j == y) {
							return true;
						} else {
							visited[j] = true;
							queue.add(j);
						}
					}
				}
			}

		}
		return false;
	}

	@Override
	public boolean Conected() {
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix.length; j++) {
				if (!PathExists(i, j)) {
					return false;
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

	@Override
	public boolean CheckEuler() {
		for (int i = 0; i < adjMatrix.length; i++) {
			if (degree(i) % 2 != 0) {
				return false;
			}
		}
		if (!Conected()) {
			return false;
		}
		return true;

	}

	
	@Override
	public boolean CheckHalfEuler() {
		int count = 0;
		if (!Conected()) {
			return false;
		}
		for (int i = 0; i < adjMatrix.length; i++) {
			if (degree(i) % 2 != 0) {
				count++;
			}
			if (count > 2) {
				return false;
			}
		}
		
		return true;

	}
	@Override
	public List<Integer> ProcessEuler(Integer s) {
	    
	    if (!this.CheckEuler()) {
	        return new ArrayList<>(); 
	    }

	    List<Integer> eulerCycle = new ArrayList<>();
	    Graph H = this.copy();
	    eulerCycle.add(s);

	    
	    while (H.edges() > 0) {
	        List<Integer> cycle = new ArrayList<>(); 

	        int v = s; 

	        while (H.degree(v) > 0) {
	            for (int u = 0; u < H.adjMatrix.length; u++) {
	                if (H.hasEdge(v, u)) {
	                    cycle.add(u);
	                    H.removeEdge(v, u);
	                    v = u;
	                    break;
	                }
	            }
	        }
	        eulerCycle.addAll(eulerCycle.indexOf(v) + 1, cycle);
	    }

	    return eulerCycle;
	}



	
	    
	

	@Override
	public Graph copy() {
	    int[][] tmp = new int[adjMatrix.length][adjMatrix.length];

	    for (int i = 0; i < adjMatrix.length; i++)
	        for (int j = 0; j < adjMatrix.length; j++) {
	            tmp[i][j] = adjMatrix[i][j];
	        }

	   
	    UnDirectedGraph copyGraph = new UnDirectedGraph(tmp);
	    for (int i = 0; i < adjMatrix.length; i++)
	        for (int j = i ; j < adjMatrix.length; j++) { 
	            if (tmp[i][j] == 1) { 
	                copyGraph.addEdge(i, j); 
	            }
	        }

	    return copyGraph;
	}

	

	public static void main(String[] args) {
		int [][] a = new int [6][6];
		UnDirectedGraph u1 = new UnDirectedGraph(a);
		u1.addEdge(0, 1);
		u1.addEdge(1, 2);
		u1.addEdge(2, 3);

		u1.addEdge(3, 4);
		u1.addEdge(4, 5);
		
		u1.addEdge(5, 0);
		
		
		
		System.out.println(u1.edges());
		
		
      
		System.out.println("Do thi co phai la Euler: " + u1.CheckEuler());
		System.out.println("Do thi co phai la Nua Euler: " + u1.CheckHalfEuler());
		System.out.println("Chu trinh Euler: " + u1.ProcessEuler(2));

	}

	@Override
	public boolean hasEdge(int i, int j) {
		
		return adjMatrix[i][j] > 0;
	}

	

	

	
}
