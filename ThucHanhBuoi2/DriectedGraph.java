package Matrix;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DriectedGraph extends Graph {

	public DriectedGraph(int[][] adjMatrix) {
		super(adjMatrix);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addEdge(int u, int v) {
		if (this.adjMatrix[u][v] == 0) {
			this.adjMatrix[u][v]++;
		}
	}

	@Override
	public void removeEdge(int u, int v) {
		if (this.adjMatrix[u][v] > 0) {
			this.adjMatrix[u][v]--;
		}

	}

	@Override
	public int degree(int v) {
		return 0;
	}

	public int Outdergee(int v) {
		int sum = 0;
		for (int i = 0; i < adjMatrix.length; i++) {
			sum += this.adjMatrix[v][i];
		}
		return sum;

	}

	public int Indergee(int v) {
		int sum = 0;
		for (int i = 0; i < adjMatrix.length; i++) {
			sum += this.adjMatrix[i][v];
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
		return sum;
	}

	@Override
	public Graph copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasEdge(int i, int j) {
		return adjMatrix[i][j] > 0;
	}

	@Override
	public boolean CheckEuler() {
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix.length; j++) {
				if (adjMatrix[i][j] > 0) {
					this.addEdge(j, i);
				}
			}
		}

		if (!this.Conected()) {
			return false;
		}
		for (int i = 0; i < adjMatrix.length; i++) {
			if (Indergee(i) != Outdergee(i)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean CheckHalfEuler() {
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix.length; j++) {
				if (adjMatrix[i][j] > 0) {
					this.addEdge(j, i);
				}
			}
		}
		int Incout = 0;
		int Outcount = 0;
		for (int i = 0; i < adjMatrix.length; i++) {
			if (Indergee(i) - Outdergee(i) > 1 && Outdergee(i) - Indergee(i) > 1) {
				return false;
			}
			if (Outdergee(i) == Indergee(i) + 1) {
				Incout++;
				if (Incout > 1)
					return false;

			}
			if (Outdergee(i) == Indergee(i) - 1) {
				Outcount++;
				if (Outcount > 1)
					return false;
			}

		}
		return Incout == 1 && Outcount == 1;
	}

	@Override
	public List<Integer> ProcessEuler(Integer s) {
		// TODO Auto-generated method stub
		return null;
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

	public static void main(String[] args) {
		int[][] matrix = new int[5][5];
		DriectedGraph d1 = new DriectedGraph(matrix);
		d1.addEdge(0, 1);
		d1.addEdge(1, 2);
		d1.addEdge(2, 3);
		d1.addEdge(3, 4);
		d1.addEdge(4, 1);

		System.out.println(d1.CheckEuler());

	}
}
