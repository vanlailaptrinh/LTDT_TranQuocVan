package ThucHanhBuoi2;

public class DriectedGraph extends Graph {

	
	public DriectedGraph(int vertex) {
		super(vertex);
	}

	@Override
	public void addEdge(int u, int v) {
     this.adjMatrix[u][v]++ ;		
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
	public int Outdergee (int v) {
		int sum = 0 ;
		for (int i = 0; i < adjMatrix.length; i++) {
			sum+= this.adjMatrix[v][i] ;
		}
		return sum;
		
	}
	public int Indergee (int v) {
		int sum = 0 ;
		for (int i = 0; i < adjMatrix.length; i++) {
			sum+= this.adjMatrix[i][v] ;
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
		return sum;
	}

}
