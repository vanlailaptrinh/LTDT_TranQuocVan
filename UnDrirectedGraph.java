package ThucHanhBuoi1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class UnDrirectedGraph extends Graph {

	@Override
	public void addVertex(String v) {
		Set<String> a = new HashSet<>();
		this.adjList.put(v, a);

	}

	@Override
	public void removeVertex(String v) {
		Iterator<Map.Entry<String, Set<String>>> iter = adjList.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Set<String>> entry = iter.next();
			if (entry.getKey().equals(v)) {
				iter.remove();
			} else {
				Set<String> values = entry.getValue();
				Iterator<String> valuesIter = values.iterator();
				while (valuesIter.hasNext()) {
					String a = valuesIter.next();
					if (a.equals(v)) {
						valuesIter.remove();
					}
				}

			}

		}

	}

	@Override
	public void addEdge(String u, String v) {
		if (this.adjList.containsKey(u) && this.adjList.containsKey(v)) {
			this.adjList.get(v).add(u);
			if (!v.equals(u)) {
				this.adjList.get(u).add(v);
			}

		}

	}

	@Override
	public void removeEdge(String u, String v) {
		this.adjList.get(u).remove(v);
	}

	@Override
	public int degree(String v) {
		int res = 0;
		for (Map.Entry<String, Set<String>> entry : adjList.entrySet()) {
			String key = entry.getKey();
			if (key.equals(v)) {
				for (String a : entry.getValue()) {
					if (a.equals(v)) {
						res = 1;
					} else {

					}
				}
				res += entry.getValue().size();
			}
		}
		return res;
	}

	@Override
	public int edges() {
		int sum = 0;
		for (Map.Entry<String, Set<String>> entry : this.adjList.entrySet()) {
			sum += degree(entry.getKey());
		}
		return sum / 2;
	}

	public boolean isBipartiteGraph() {
		int V = adjList.size();
		int[] colors = new int[V];

		for (int i = 0; i < V; i++) {
			colors[i] = -1;
		}

		for (Map.Entry<String, Set<String>> entry : adjList.entrySet()) {
			String vertex = entry.getKey();
			int index = getVertexIndex(vertex);

			if (colors[index] == -1) {
				if (!isBipartiteUtil(index, colors)) {
					return false;
				}
			}
		}

		return true;
	}

	private int getVertexIndex(String vertex) {
		int index = 0;
		for (Map.Entry<String, Set<String>> entry : adjList.entrySet()) {
			if (entry.getKey().equals(vertex)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	private boolean isBipartiteUtil(int index, int[] colors) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(index);
		colors[index] = 0;
		while (!queue.isEmpty()) {
			int u = queue.poll();

			for (String neighbor : adjList.get(getVertexLabel(u))) {
				int v = getVertexIndex(neighbor);
				if (colors[v] == -1) {
					colors[v] = 1 - colors[u];
					queue.add(v);
				} else if (colors[v] == colors[u]) {
					return false;
				}
			}
		}

		return true;
	}

	private String getVertexLabel(int index) {
		int currentIndex = 0;
		for (String vertex : adjList.keySet()) {
			if (currentIndex == index) {
				return vertex;
			}
			currentIndex++;
		}
		return null;
	}

	// Code khác ở đây...

}
