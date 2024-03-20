package ThucHanhBuoi2;

public class UnDirectedGraph extends Graph {

	public UnDirectedGraph(int vertex) {
		super(vertex);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addEdge(int u, int v) {
		this.adjMatrix[u][v]++ ;
		if (u!=v) {
			this.adjMatrix[v][u]++ ;
		}
	}

	@Override
	public void removeEdge(int u, int v) {
		if (this.adjMatrix[u][v] >0 && this.adjMatrix[v][u]>0) {
			this.adjMatrix[u][v]-- ;
			this.adjMatrix[v][u]-- ;
		}
		
	}

	@Override
	public int degree(int v) {
		int sum = 0 ;
		for (int i = 0; i < adjMatrix.length; i++) {
			sum+= this.adjMatrix[v][i] ;
		}
		return sum;
	}

	@Override
	public int edges() {
		int sum = 0 ;
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix.length; j++) {
				sum+= this.adjMatrix[i][j] ;
			}
		}
		return sum/2;
	}

}
