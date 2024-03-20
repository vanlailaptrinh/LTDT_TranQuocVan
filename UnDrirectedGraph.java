package ThucHanhBuoi1;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public abstract class Graph {

	protected Map<String, Set<String>> adjList;
	protected Boolean [] visited;

	public Graph() {

		adjList = new LinkedHashMap<>();
	}

	public abstract void addVertex(String v);

	public abstract void removeVertex(String v);

	public abstract void addEdge(String u, String v);

	public abstract void removeEdge(String u, String v);

	public abstract int degree(String v);

	public abstract int edges();
	
	public abstract Boolean checkSingleGraph ();
	
	public abstract void BFS (int v) ;

	public void print() {
		for (Map.Entry<String, Set<String>> entry : adjList.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue());
		}
	}
	public void printEdges () {
		LinkedList<String> list = new LinkedList<>();
		for (Map.Entry<String, Set<String>> string : adjList.entrySet()) {
			if (string.getValue().size()!= 0) {
				for (String vertex : string.getValue()) {
					String edge = string.getKey() + vertex ;
					list.add(edge);
				}
			}
 		}
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ,");
		}
	}

	
	
}
