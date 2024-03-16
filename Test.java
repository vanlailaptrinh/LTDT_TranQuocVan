package ThucHanhBuoi1;

public class Test {
	public static void main(String[] args) {
		UnDrirectedGraph g1 = new UnDrirectedGraph();
		g1.addVertex("A");
		g1.addVertex("B");
		g1.addVertex("C");
		g1.addVertex("D");
		g1.addVertex("E");

		g1.addEdge("A", "B");
		g1.addEdge("A", "E");
		g1.addEdge("A", "D");

		g1.addEdge("B", "B");
		g1.addEdge("B", "C");
		g1.addEdge("B", "E");
		g1.addEdge("B", "D");

		g1.addEdge("D", "E");

		g1.addEdge("A", "B");
		
		g1.print();

		System.out.println(g1.degree("B"));
		System.out.println(g1.edges());
		
		
		DrirectedGraph g2 = new DrirectedGraph();
		g2.addVertex("A");
		g2.addVertex("B");
		g2.addVertex("C");
		g2.addVertex("D");
	    g2.addVertex("E");
		g2.addEdge("A", "B");
		

		g2.addEdge("B", "E");

		g2.addEdge("C", "C");
		g2.addEdge("C", "B");
		g2.addEdge("C", "D");

		g2.addEdge("D", "C");
		
		g2.addEdge("E", "E");
		g2.addEdge("E", "A");
		g2.addEdge("E", "D");




		g2.print();

		System.out.println(g2.Outdegree("D"));
		System.out.println(g2.Indegree("D"));
		System.out.println(g2.edges());
	}


	}

